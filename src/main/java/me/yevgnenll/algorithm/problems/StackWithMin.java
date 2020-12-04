package me.yevgnenll.algorithm.problems;

import java.util.Stack;


public class StackWithMin extends Stack {

  private long min = Integer.MIN_VALUE;

  @Override
  public Object push(Object item) {
    long e = (long) item;
    if (e < min) {
      min = Math.min(min, e);
    }
    return super.push(new StackStatus(min, e));
  }

  @Override
  public synchronized Object pop() {
    StackStatus item = (StackStatus) super.pop();
    if (item.getValue() == min) {
      StackStatus previous = (StackStatus) super.peek();
      min = previous.getMin();
    }
    return item.getValue();
  }

  public long min() {
    return min;
  }

  class StackStatus {
    private long min;
    private long value;
    StackStatus(long min, long value) {
      this.min = min;
      this.value = value;
    }
    public long getMin() {
      return min;
    }

    public long getValue() {
      return value;
    }
  }
}
