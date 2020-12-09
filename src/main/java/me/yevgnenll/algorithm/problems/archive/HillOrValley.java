package me.yevgnenll.algorithm.problems.archive;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

import org.junit.jupiter.api.Test;

public class HillOrValley {

  public int solution(int A) {
    if (A < 10) return A;

    String number = String.valueOf(A);
    int length = number.length();
    int dest = length % 2 + length / 2;

    String result = "";
    char[] n = number.toCharArray();
    for (int i = 0 ; i < dest ; i ++) {
      int back = length - 1 - i;
      result += String.valueOf(n[i]);
      if (isAppendLast(length, back, dest)) {
        result += String.valueOf(n[back]);
      }
      System.out.println(result);
    }
    return Integer.parseInt(result);
  }
  private boolean isAppendLast(int length, int back, int dest) {
    return length % 2 == 0 || (length % 2 == 1 && back > dest - 1);
  }


  @Test
  public void test() {
    assertThat(solution(123456), is(162534));
    assertThat(solution(12345), is(15243));
    assertThat(solution(103), is(130));

  }

}
