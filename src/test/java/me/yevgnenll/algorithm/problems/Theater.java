package me.yevgnenll.algorithm.problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class Theater {

  public int solution(int n) {
    boolean searching = true;
    int num = n + 1;
    while (searching) {
      if (isSparse(num)) {
        return num;
      }
      num += 1;
    }
    return num;
  }

  private boolean isSparse(int n) {
    String bin = Integer.toBinaryString(n);
    String[] split = bin.split("0");
    for (String s : split) {
      if (s.length() > 1) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void test() {
    assertEquals(32, solution(21));
    assertEquals(40, solution(38));
    System.out.println(isSparse(21));
    System.out.println(isSparse(32));
    System.out.println(isSparse(38));
    System.out.println(isSparse(40));
  }
}
