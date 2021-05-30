package com.gs.bfs.jumpgame;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Gopal Selvaraj
 * 
 *  S = 011010, min = 2, max 3
 *  
 *   - start at 0th index
 *   - 0 being stone amd 1 being water
 *   - first time jump 3 step , reach 3rd index.
 *   - second jump 2 step , reach 5th index
 *   
 *   
 *
 */
public class JumpGameVII {

	public boolean canReach(String s, final int minJump, final int maxJump) {

		if (s == null || s.trim().isEmpty() || s.endsWith("1")) {
			return false;
		}

		final int LAST_INDEX = s.length() - 1;
		
		if( minJump > LAST_INDEX) {
			return false;
		}
		
		Deque<Integer> positionQueue = new ArrayDeque<Integer>();
		positionQueue.offer(0);

		while (!positionQueue.isEmpty()) {
			int peekLast = positionQueue.peekLast();
			int position = positionQueue.poll();
			if (position == LAST_INDEX) return true;
			int start = Math.max(peekLast, position + minJump);
			int end = Math.min(position + maxJump, LAST_INDEX);
			
			for ( int jump = start; jump <= end; jump++) {
				if(s.charAt(jump) == '0') {
					positionQueue.offer(jump);
				}
			}
			
		}

		return false;

	}

}
