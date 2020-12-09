package me.yevgnenll.algorithm.problems.archive;

import java.util.Stack;

/**
 * 가장 작은 값이 위로 오는 정렬 기능이 있는 stack 이다.
 * stack은 최대 2개까지 사용이 가능하며 그 이외의 자료구조는 사용할 수 없다.
 */
public class SortStack {

  public SortStack() {}

  public SortStack(Stack<Integer> stack) {
    origin = stack;
  }

  private Stack<Integer> origin = new Stack<>();

  public int pop() {
    return origin.pop();
  }

  public int peek() {
    return origin.peek();
  }

  public boolean isEmpty() {
    return origin.isEmpty();
  }

  public int push(int item) {
    if(isEmpty()) {
      return origin.push(item);
    }
    int result = origin.push(item);
    sort();
    return result;
  }

  public void sort() {
    Stack<Integer> sorting = new Stack<>();
    while (!origin.isEmpty()) {
      int pop = origin.pop();
      while(!sorting.isEmpty() && pop < sorting.peek()) {
        origin.push(sorting.pop());
      }
      sorting.push(pop);
    }
    // 정렬 완료.
    while (!sorting.isEmpty()) {
      origin.push(sorting.pop());
    }
  }

  public Stack<Integer> get() {
    sort();
    return origin;
  }

}
