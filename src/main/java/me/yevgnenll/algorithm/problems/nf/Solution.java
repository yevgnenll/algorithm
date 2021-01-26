package me.yevgnenll.algorithm.problems.nf;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Solution {

  int solution(int[] A, int X) {
    int N = A.length;
    if (N == 0) {
      return -1;
    }
    int l = 0;
    int r = N - 1;
    while (l < r) {
      int m = (l + r) / 2;
      if (A[m] > X) {
        r = m - 1;
      } else if (A[m] == X) {
        return m;
      } else {
        l = m + 1;
      }
    }
    if (A[l] == X) {
      return l;
    }
    return -1;
  }

  @Test
  void test() {
    assertThat(solution(new int[] {1, 2}, 2)).isEqualTo(1);
    assertThat(solution(new int[] {1, 2, 5, 9, 9}, 5)).isEqualTo(2);
    assertThat(solution(new int[] {5, 9, 9, 9, 9}, 5)).isEqualTo(0);
    assertThat(solution(new int[] {9, 9, 9, 9, 10}, 10)).isEqualTo(4);
  }

}
