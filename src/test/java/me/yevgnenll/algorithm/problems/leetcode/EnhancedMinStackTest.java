package me.yevgnenll.algorithm.problems.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnhancedMinStackTest {

  @Test
  void test() {
    EnhancedMinStack minStack = new EnhancedMinStack();
    minStack.push(0);
    minStack.push(1);
    minStack.push(1);
    minStack.push(0);

    assertThat(minStack.getMin()).isEqualTo(0);
    minStack.pop();
    assertThat(minStack.getMin()).isEqualTo(0);

  }

}
