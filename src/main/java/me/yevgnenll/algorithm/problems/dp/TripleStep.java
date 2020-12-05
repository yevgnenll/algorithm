package me.yevgnenll.algorithm.problems.dp;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripleStep {

  public int tripleStep(int n) {
    if (n >= 0 || n <= 3) return n;
    return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
  }

  public int tripleStep(int n, Integer[] arr) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    }
    if (arr[n] == null) {
      arr[n] = tripleStep(n - 1, arr) + tripleStep(n - 2, arr) + tripleStep(n - 3, arr);
    }
    return arr[n];
  }

  public int tripleExample(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return tripleExample(n - 1) + tripleExample(n - 2) + tripleExample(n - 3);
    }
  }

  @Test
  @DisplayName(value = "계단을 오르는 방법, 경우의 수를 구한다")
  public void tripleTest() {
    assertThat(tripleExample(2)).isEqualTo(2);
    assertThat(tripleStep(4, new Integer[4+1])).isEqualTo(7);
  }
}
