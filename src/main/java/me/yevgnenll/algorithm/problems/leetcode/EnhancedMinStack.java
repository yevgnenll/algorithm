package me.yevgnenll.algorithm.problems.leetcode;

import java.util.Stack;

/**
 * discuss 에서 발견한 stack을 하나만 사용하는 방법
 * 출처: https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack
 */
public class EnhancedMinStack {
  int min = Integer.MAX_VALUE;
  Stack<Integer> stack = new Stack<>();

  /**
   * 문제가 되는건 min을 pop 했을때 그 다음 최소값을 어떻게 찾아낼 것인가? 이다.
   * discuss 에서 발견한 풀이는 변경될 때 현재 min 값을 먼저 저장하고, 새로운 min 값을
   * 그 다음에 저장한다
   *
   * 그리고 pop 을 할때 min == pop 이 일치하면 한번 더 pop 을 하는 규칙을 갖는다
   * 천재인데?
   * @param x
   */
  public void push(int x) {
    // only push the old minimum value when the current
    // minimum value changes after pushing the new value x
    if(x <= min){
      stack.push(min);
      min=x;
    }
    stack.push(x);
  }

  public void pop() {
    // if pop operation could result in the changing of the current minimum value,
    // pop twice and change the current minimum value to the last minimum value.
    if(stack.pop() == min) {
      min=stack.pop();
      System.out.println(min);
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
