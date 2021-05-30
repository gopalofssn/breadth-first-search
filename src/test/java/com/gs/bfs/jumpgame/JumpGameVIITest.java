package com.gs.bfs.jumpgame;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JumpGameVIITest {

  private JumpGameVII jumpGame = new JumpGameVII();

  @Test
  public void testReachScnerio() {
    String s = "011010";
    assertTrue(jumpGame.canReach(s, 2, 3));
  }

  @Test
  public void testNotReachScnerio() {
    assertFalse(jumpGame.canReach("01101110", 2, 3));
    assertFalse(jumpGame.canReach(null, 2, 3));
    assertFalse(jumpGame.canReach("", 2, 3));
    assertFalse(jumpGame.canReach("011011101", 2, 3));
    assertFalse(jumpGame.canReach("011011101", 20, 30));
  }

}
