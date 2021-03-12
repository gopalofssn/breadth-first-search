package com.gs.bfs.island;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindRightTopAndBottomLeftCornerOfRectangleIsland {

  private boolean[][] visited;
  
  public int[][][] find(int[][] grid) {
    
    final int ROWS = grid.length;
    final int COLS = grid[0].length;
    visited = new boolean[ROWS][COLS];
    List<int[][]> results = new ArrayList<int[][]>();
    
    for(int row = 0; row < ROWS; row++) {
      for(int col = 0; col < COLS; col++) {
        if(!visited[row][col] && grid[row][col] == 0) {
          int[] topLeft = new int[] {row, col};
          int[] bottomRight = bottomRightFinderBfs(grid, row, col);
          results.add(new int[][] {topLeft,  bottomRight});
        }
        visited[row][col] = true;
      }
    }
    
    return convertAndSend(results);
  }

  private int[] bottomRightFinderBfs(int[][] grid, int row, int col) {
    int[] bottomRight = new int[] {row, col};
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.offer(new int[] {row, col});
    
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for(int index = 0; index < sz; index++) {
        bottomRight = queue.poll();
        addNeighboursToQueue(queue, grid, bottomRight[0], bottomRight[1]);
      }
    }
        
    return bottomRight;
  }

  private void addNeighboursToQueue(Queue<int[]> queue, int[][] grid, int row, int col) {
    int[][] directions = { {1, 0}, {0, 1} };
    for(int[] direction : directions) {
      addNeighboursToQueueHelper(queue, grid, row + direction[0], col + direction[1]);
    }
    
  }

  private void addNeighboursToQueueHelper(Queue<int[]> queue, int[][] grid, int row, int col) {
    if(outOfBoundary(grid, row, col) || visited[row][col] || grid[row][col] != 0) {
      return;
    }
    visited[row][col] = true;
    queue.offer(new int[] {row, col});
  }

  private boolean outOfBoundary(int[][] grid, int row, int col) {
    return row >= grid.length || col >= grid[0].length;
  }

  private int[][][] convertAndSend(List<int[][]> results) {
    int[][][] corners = new int[results.size()][][];
    int index = 0;
    for(int[][] result : results) {
      corners[index] = result;
      index++;
    }
    return corners;
  }

}
