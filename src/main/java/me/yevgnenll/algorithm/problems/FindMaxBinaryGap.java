package me.yevgnenll.algorithm.problems;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FindMaxBinaryGap {

  public int solution(int n) {
    String bin = Integer.toBinaryString(n);
    String[] zeroArray = bin.split("1");
    char lastWord = bin.toCharArray()[bin.length() - 1];
    int max = 0;
    int last = zeroArray.length;
    for (int i = 1; i < last ; i ++) {
      if (i == last - 1 && lastWord != '1') {
        break;
      }
      if (zeroArray[i].length() > max) {
        max = zeroArray[i].length();
      }
    }
    return max;
  }

  @Test
  public void test() {
    assertEquals(4, solution(529));
    assertEquals(0, solution(32));
    assertEquals(29 , solution(1073741825));
  }

  @Test
  public void test2() {
    System.out.println(Integer.toBinaryString(38));
    System.out.println(Integer.toBinaryString(39));
    System.out.println(Integer.toBinaryString(40));
  }

}
