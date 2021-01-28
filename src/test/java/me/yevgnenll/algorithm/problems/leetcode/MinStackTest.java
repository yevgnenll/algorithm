package me.yevgnenll.algorithm.problems.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinStackTest {

  /**
   *  if (getMin() >= x) { 를 사용해야 했던 이유
   */
  @Test
  void stack() {
    MinStack minStack = new MinStack();
    minStack.push(0);
    minStack.push(1);
    minStack.push(0);
    assertThat(minStack.getMin()).isEqualTo(0);
    minStack.pop();
    assertThat(minStack.getMin()).isEqualTo(0);
  }

}
