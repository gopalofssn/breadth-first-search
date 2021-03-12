package com.gs.bfs.island;

import static org.testng.Assert.assertEquals;
import org.junit.Test;

public class FindNumbersOfIslandTest {

  private FindNumbersOfIsland findNumbersOfIsland = new FindNumbersOfIsland();
  
  @Test
  public void testCase1() {
    int[][] grid = { {1, 1, 1}, {1, 1, 1} };
    assertEquals(0, findNumbersOfIsland.find(grid));
  }
  
  @Test
  public void testCase2() {
    int[][] grid = { {1, 0, 1}, {1, 1, 0} };
    assertEquals(2, findNumbersOfIsland.find(grid));
  }
  
  @Test
  public void testCase3() {
    int[][] grid = { {1, 0, 0}, {1, 1, 0} };
    assertEquals(1, findNumbersOfIsland.find(grid));
  }
 
}
