package me.yevgnenll.algorithm.problems.archive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStack <T> {
  private List<Stack<T>> stackList = new ArrayList<>();
  private Stack<T> stack = new Stack<>();
  private int stackCapacity;
  public SetOfStack(int capa) {
    stackCapacity = capa;
  }

  public T push(T item) {
    if (isFull()) {
      stackList.add(stack);
      this.stack = new Stack<>();
    }
    return stack.push(item);
  }

  public T pop() {
    T item = stack.pop();
    if (stack.size() == 0 && stackList.size() >= 1) {
      stack = stackList.get(stackList.size() - 1);
      stackList.remove(stackList.size() - 1);
    }
    return item;
  }

  public T popAt(int index) {
    if (index == stackList.size()) {
      return stack.pop();
    }
    Stack<T> stackByIndex = stackList.get(index);
    return stackByIndex.pop();
  }

  public T peek() {
    return stack.peek();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  private boolean isFull() {
    return stack.size() == stackCapacity;
  }

  private Stack<T> getLastStack() {
    if (stackList.size() == 0) return null;
    return stackList.get(stackList.size() - 1);
  }

}
