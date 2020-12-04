package me.yevgnenll.algorithm.problems;

import java.util.EmptyStackException;

public class FixedMultiStack<T> {
  private int numberOfStacks = 3;
  private int stackCapacity; // 하나의 스택에 몇 개 element 를 저장할 것인가?
  private Object[] values;
  private int[] sizes; // 해당 스택의 사이즈가 몇?

  public FixedMultiStack(int stackSize) {
    stackCapacity = stackSize;
    values = new Object[stackSize * numberOfStacks]; // size * 3
    sizes = new int[numberOfStacks]; // 3개
  }
  public void push(int stackNum, T value) throws FullStackException {
    if (isFull(stackNum)) {
      throw new FullStackException();
    }
    sizes[stackNum] ++; // 새로운 데이터가 들어왔으니 size 를 증가시킨다.
    values[indexOfTop(stackNum)] = value; // 가장 위에 값을 할당한다.
  }

  public T pop(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int topIndex = indexOfTop(stackNum); // 각 스택의 가장 위 index 를 알아낸다.
    T value = (T) values[topIndex]; // 값을 꺼내와 casting 한다.
    values[topIndex] = null; // 가장 위 index 의 value 를 지운다
    sizes[stackNum] --; // 해당 stack 의 size 감소
    return value;
  }

  public T peek(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    return (T) values[indexOfTop(stackNum)]; // 값을 보여주기만 하니 별도의 로직은 없다
  }

  private boolean isEmpty(int stackNum) {
    return sizes[stackNum] == 0; // 해당 스택의 size 가 0 이면 빈 것이다.
  }

  private int indexOfTop(int stackNum) {
    int start = stackNum * stackCapacity;
    int last = sizes[stackNum];
    return start + last - 1;
  }

  private boolean isFull(int stackNum) {
    return sizes[stackNum] == stackCapacity;
  }
}
