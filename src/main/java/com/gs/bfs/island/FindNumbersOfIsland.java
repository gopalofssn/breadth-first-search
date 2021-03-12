package com.gs.bfs.island;

public class FindNumbersOfIsland {

  enum Directions {
    UP(-1, 0), 
    LEFT(0, -1), 
    DOWN(1, 0), 
    RIGHT(0, 1);

    int ROW;
    int COL;

    Directions(int row, int col) {
      ROW = row;
      COL = col;
    }
  }

  public int find(int[][] grid) {

    final int ROWS = grid.length;
    final int COLS = grid[0].length;
    int numberOfIsland = 0;
    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLS; col++) {
        if (grid[row][col] == 0) {
          helper(grid, row, col);
          numberOfIsland++;
        }
      }
    }

    return numberOfIsland;
  }

  private void helper(int[][] grid, int row, int col) {
    if (outOfBoundary(grid, row, col) || grid[row][col] != 0) {
      return;
    }

    grid[row][col] = 1;
    
    helper(grid, Directions.LEFT.ROW + row,  Directions.LEFT.COL + col);
    helper(grid, Directions.RIGHT.ROW + row,  Directions.RIGHT.COL + col);
    helper(grid, Directions.UP.ROW + row,  Directions.UP.COL + col);
    helper(grid, Directions.DOWN.ROW + row,  Directions.DOWN.COL + col);
    
    /*for (Directions direction : Directions.values()) {
      helper(grid, row + direction.ROW, col + direction.COL);
    }*/
  }

  private boolean outOfBoundary(int[][] grid, int row, int col) {
    return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
  }

}
