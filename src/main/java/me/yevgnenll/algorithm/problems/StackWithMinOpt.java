package me.yevgnenll.algorithm.problems;

import java.util.Stack;

public class StackWithMinOpt extends Stack<Integer> {
  private Stack<Integer> min = new Stack<>();
  @Override
  public Integer push(Integer item) {
    if (item <= min()) { // 동일한 최소값이 여러번 들어온다면?
      min.push(item);
    }
    return super.push(item);
  }

  @Override
  public synchronized Integer pop() {
    int item = super.pop();
    if (item == min()) {
      min.pop();
    }
    return item;
  }

  public int min() {
    if (min.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return min.peek();
    }
  }
}
