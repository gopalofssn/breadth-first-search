package com.gs.bfs.two.dimensional.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LevelOrderDataCollectorTest {

  private LevelOrderDataCollector levelOrderDataCollector  = new LevelOrderDataCollector();
  
  @Test
  public void testCase1() {
    int[][] input = {
                      {1,   2,  3,  4},
                      {5,   6,  7,  8},
                      {9,  10, 11, 12},
                      {13, 14, 15, 16}
                     };
    List<List<Integer>> actual = levelOrderDataCollector.collect(input);
    
    @SuppressWarnings("serial")
    List<List<Integer>> expected = new ArrayList<List<Integer>>() {{
                                      add(new ArrayList<Integer>(Arrays.asList(1)));
                                      add(new ArrayList<Integer>(Arrays.asList(5, 2)));
                                      add(new ArrayList<Integer>(Arrays.asList(9, 6, 3)));
                                      add(new ArrayList<Integer>(Arrays.asList(13, 10, 7, 4)));
                                      add(new ArrayList<Integer>(Arrays.asList(14, 11, 8)));
                                      add(new ArrayList<Integer>(Arrays.asList(15, 12)));
                                      add(new ArrayList<Integer>(Arrays.asList(16)));
                                    }};
   assertListOfListMatch(expected, actual);
    
  }

  private void assertListOfListMatch(List<List<Integer>> expected, List<List<Integer>> actual) {
    assertTrue(expected.size() == actual.size());
    for(int index = 0; index < actual.size(); index++) {
      assertLinesMatch(expected.get(index), actual.get(index));
    }
  }

  private void assertLinesMatch(List<Integer> expected, List<Integer> actual) {
    assertTrue(expected.size() == actual.size());
    for(int index = 0; index < actual.size(); index++) {
      assertEquals(expected.get(index), actual.get(index));
    }
  }
}
