package me.yevgnenll.algorithm.problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FindUnPairNumber {

  public int solution(int[] a) {
    int res = 0;
    for (int n : a) {
      res = n ^ res;
    }
    return res;
  }

  @Test
  public void 반환값은_7_이다() {
    int[] a = {9, 3, 9, 3, 9, 7, 9};
    assertEquals(7, solution(a));
  }
}

