package com.gs.bfs.level.order.data.collector;

import java.util.*;
/**
 * 
 * @author Gopal Selvaraj
 * Level order left to right data collection
 */
public class LevelOrderDataCollector {

  private boolean[][] visited;
  
  public List<List<Integer>> collect(int[][] grid) {

    visited = new boolean[grid.length][grid[0].length];
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.offer(new int[] {0, 0});
    visited[0][0] = true;
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    while (!queue.isEmpty()) {
        int currentLevelSize = queue.size();
        List<Integer> levelList = new ArrayList<Integer>();
        for(int index = 0; index < currentLevelSize; index++) {
          int[] current = queue.poll();
          int row = current[0];
          int col = current[1];
          levelList.add(grid[row][col]);
          addNeighboursToQueue(queue, grid, row, col);
        }
        result.add(levelList);
    }

    return result;
  }

  private void addNeighboursToQueue(Queue<int[]> queue, int[][] grid, int row, int col) {
    int[][] directions = { {1, 0}, {0, 1} };
    for(int[] direction : directions) {
      addToQueue(queue, grid, row + direction[0] , col + direction[1]);
    }
    
  }

  private void addToQueue(Queue<int[]> queue, int[][] grid, int row, int col) {
    if(outOfBoundary(grid, row, col) || visited[row][col]) {
      return;
    }
    queue.offer(new int[] {row, col});
    visited[row][col] = true; 
  }

  private boolean outOfBoundary(int[][] grid, int row, int col) {
    return row >= grid.length || col >= grid[0].length;
  }

}
