package com.gs.bfs.two.dimensional.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RottenOrangesTest {

  private RottenOranges rottenOranges = new RottenOranges();

  @Test
  public void testCase1() {
    int grid[][] = {
                      {2, 1, 1}, 
                      {1, 1, 0}, 
                      {0, 1, 1}
                    };
    assertEquals(4, rottenOranges.calculateTime(grid));
  }
  
  @Test
  public void testCase2() {
    int grid[][] = {
                      {2, 1, 1}, 
                      {0, 1, 1}, 
                      {1, 0, 1}
                    };
    assertEquals(-1, rottenOranges.calculateTime(grid));
  }
  
  @Test
  public void testCase3() {
    int grid[][] = {
                      {0,2}
                    };
    assertEquals(0, rottenOranges.calculateTime(grid));
  }
  
  
  @Test
  public void testCase4() {
    int grid[][] = {
                      {0,1}
                    };
    assertEquals(-1, rottenOranges.calculateTime(grid));
  }
  
}
