package me.yevgnenll.algorithm.problems.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursiveMultiple {

  public int solution(int a, int b) {
    if (b == 1) return a;
    if (b % 2 == 0) {
      a = a << 1;
      return solution(a, b/2);
    }
    for (int i = 0; i < b; i += b) {
      a += a;
    }
    return a;
  }

  @Test
  void multiple() {
    Assertions.assertThat(solution(4, 2)).isEqualTo(8);
    Assertions.assertThat(solution(9, 3)).isEqualTo(27);
  }

}
