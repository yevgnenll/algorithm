package me.yevgnenll.algorithm.problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BalancedStringSplit {

  public int balancedStringSplit(String s) {
    char[] str = s.toCharArray();
    int count = 0;
    int res = 0;
    for (int i = 0; i < str.length ; i ++) {
      char c = str[i];
      if (c == 'L') count ++;
      if (c == 'R') count --;
      if (count == 0) res ++;
    }
    return res;
  }

  @Test
  public void RLRRLLRLRL_는_답이_4() {
    assertEquals(balancedStringSplit("RLRRLLRLRL"), 4);
  }

  @Test
  public void RLLLLRRRLR_의_답은_3() {
    assertEquals(balancedStringSplit("RLLLLRRRLR"), 3);
  }

}
