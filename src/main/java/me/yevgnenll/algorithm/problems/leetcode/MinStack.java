package me.yevgnenll.algorithm.problems.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack
 * 가장 작은값을 반환하는 기능이 있는 Stack을 구현한다.
 */
public class MinStack {

  private Stack<Integer> min;
  private Stack<Integer> stack;

  /** initialize your data structure here. */
  public MinStack() {
    this.min = new Stack<>();
    this.stack = new Stack<>();
  }

  public void push(int x) {
    if (getMin() >= x) {
      min.push(x);
    }
    stack.push(x);
  }

  public void pop() {
    int pop = stack.pop();
    if (getMin() == pop) {
      min.pop();
    }

  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    if (min.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return min.peek();
    }
  }

}
