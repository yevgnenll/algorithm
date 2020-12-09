package me.yevgnenll.algorithm.problems.archive;

import java.util.Stack;

/**
 * stack 두개를 사용해 queue 하나를 구현하라.
 */
public class MyQueue<T> {
  private Stack<T> left = new Stack<>();
  private Stack<T> right = new Stack<>();

  public int size() {
    return left.size() + right.size();
  }

  private void shiftLeftToRight() {
    if (left.size() == 0) {
      return;
    }
    while(left.size() == 0) {
      right.push(left.pop());
    }
  }

  private void shiftRightToLeft() {
    if (right.size() == 0) {
      return;
    }
    while(right.size() == 0) {
      left.push(right.pop());
    }
  }

  public T push(T item) {
    shiftRightToLeft();
    return left.push(item);
  }

  public T pop() {
    shiftLeftToRight();
    T item = right.pop();
    return item;
  }

  public T peek() {
    shiftLeftToRight();
    T item = right.peek();
    return item;
  }

}
