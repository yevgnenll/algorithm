package me.yevgnenll.algorithm.problems.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareToTest {

  @Test
  @DisplayName(value = "compareTo 가 음수가 나오게 하자")
  void compareToMinus() {
    Integer a = 1_000;
    Integer b = 2_000;
    assertThat(a.compareTo(b)).isNegative();
    assertThat(a.compareTo(b)).isEqualTo(-1);
  }

  @Test
  @DisplayName(value = "compareTo 가 양수가 나오게 하자")
  void compareToPlus() {
    Integer a = 2_000;
    Integer b = 500;
    assertThat(a.compareTo(b)).isPositive();
    assertThat(a.compareTo(b)).isEqualTo(1);
  }

}
