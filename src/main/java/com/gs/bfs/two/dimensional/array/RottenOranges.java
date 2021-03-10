package com.gs.bfs.two.dimensional.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import com.google.common.collect.Sets;

/**
 * 
 * @author Gopal Selvaraj
 *
 *         0 : empty cell 
 *         1 : fresh orange 
 *         2 : rotten orange
 * 
 *         every minute , 4-directional adjecent to a rotten orange become rotten
 */
public class RottenOranges {

  private int freshOranges = 0;

  public int calculateTime(int[][] grid) {

    Queue<int[]> rottenOrangeQueue = new LinkedList<int[]>();
    buildRottenOrangeQueueAndCalculateFreshOrangeCount(grid, rottenOrangeQueue);
    if (freshOranges == 0) {
      return 0;
    }
    
    if(rottenOrangeQueue.isEmpty()) {
      return -1;
    }
    
    int timeTaken = 0;
    
    while(!rottenOrangeQueue.isEmpty() && freshOranges > 0) {
      int currentSize = rottenOrangeQueue.size();
      int infectedCount = 0;
      for(int index = 0; index < currentSize; index++) {
        int[] current = rottenOrangeQueue.poll();
        infectedCount += infectNeighboursAndGetInfectedCount(grid, rottenOrangeQueue, current);
      }
      timeTaken++;
      freshOranges -= infectedCount;      
    }
    
    return freshOranges ==0 ? timeTaken : -1;
  }

  private int infectNeighboursAndGetInfectedCount(int[][] grid, Queue<int[]> rottenOrangeQueue, int[] current) {
    int infectedCount = 0;
    int[][] directions = { {-1 , 0}, {0, -1}, {1, 0}, {0, 1} };
    for(int[] dir : directions) {
      int row = current[0] + dir[0];
      int col = current[1] + dir[1];
      if(hasInfectedAdjacentCell(grid, row, col)) {
        rottenOrangeQueue.offer(new int[] {row, col});
        infectedCount++;
      }
    }
    return infectedCount;
  }

  private boolean hasInfectedAdjacentCell(int[][] grid, int row, int col) {
    if(outOfBoundary(grid, row, col)) {
      return false;
    }
    
    Set<Integer> ignorableCellStatusCodes = new HashSet<Integer>(Arrays.asList(0, 2));
    int currentCellStatusCode = grid[row][col]; 
    if(ignorableCellStatusCodes.contains(currentCellStatusCode)) {
      return false;
    }

    grid[row][col] = 2;
    return true;
  }

  private boolean outOfBoundary(int[][] grid, int row, int col) {
    return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
  }

  private void buildRottenOrangeQueueAndCalculateFreshOrangeCount(int[][] grid, Queue<int[]> rottenOrangeQueue) {

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        int val = grid[row][col];
        if (val == 1) {
          freshOranges++;
        } else if (val == 2) {
          rottenOrangeQueue.offer(new int[] {row, col});
        }
      }
    }
  }
  
}
