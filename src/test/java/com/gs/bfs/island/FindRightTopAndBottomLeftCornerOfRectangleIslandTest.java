package com.gs.bfs.island;

import static org.testng.Assert.assertEquals;
import org.junit.Test;

public class FindRightTopAndBottomLeftCornerOfRectangleIslandTest {

  private FindRightTopAndBottomLeftCornerOfRectangleIsland findRightTopAndBottomLeftCornerOfRectangleIsland = new FindRightTopAndBottomLeftCornerOfRectangleIsland();
  
  @Test
  public void testCase1() {
    int[][] grid = { {1, 1, 1}, {1, 1, 1} };
    int[][][] actual = findRightTopAndBottomLeftCornerOfRectangleIsland.find(grid);
    assertEquals(0, actual.length);
  }
  
  @Test
  public void testCase2() {
    int[][] grid = { {1, 0, 1}, {1, 1, 0} };
    int[][][] actual = findRightTopAndBottomLeftCornerOfRectangleIsland.find(grid);
    assertEquals(2, actual.length);
    int[][][] expected = { 
                              {{0, 1}, {0, 1}},
                              {{1, 2}, {1, 2}}
                           };
    assertEquals(actual, expected);
  }
  
  @Test
  public void testCase3() {
    int[][] grid = { {1, 0, 0}, {1, 0, 0} };
    int[][][] actual = findRightTopAndBottomLeftCornerOfRectangleIsland.find(grid);
    assertEquals(1, actual.length);
    int[][][] expected = { 
                            {{0, 1}, {1, 2}}
                         };
    assertEquals(actual, expected);
  }
 
  @Test
   public void test() {
    int[][][] actual = { 
                          {{0, 1}, {1, 2}}
                       };
    int[][][] expected = { 
                          {{0, 1}, {1, 2}}
                       };
    assertEquals(actual, expected);
  }
}
