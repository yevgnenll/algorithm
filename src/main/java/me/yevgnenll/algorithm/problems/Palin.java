package me.yevgnenll.algorithm.problems;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

import org.junit.jupiter.api.Test;

public class Palin {

  public String solution(String S) {
    char[] charArray = S.toCharArray();

    int length = S.length();
    for (int i = 0 ; i < length / 2 + length % 2 ; i ++) {
      if (isBothMirrorQuestionMark(charArray, i)) {
        charArray[i] = 'a';
        charArray[length - i - 1] = 'a';
      } else if (isQuestionMark(charArray, i)) {
        charArray[i] = charArray[length - i - 1];
      } else if (isQuestionMark(charArray, length - i - 1)) {
        charArray[length - i - 1] = charArray[i];
      } else if (charArray[i] != charArray[length - i - 1]) {
        return "NO";
      }
    }
    return String.valueOf(charArray);
  }

  private boolean isBothMirrorQuestionMark(char[] chars, int index) {
    int length = chars.length;
    return chars[index] == '?' && chars[length - index - 1] == '?';
  }

  private boolean isQuestionMark(char[] chars, int index) {
    return chars[index] == '?';
  }

  private int date(String a, String b) {
    return 0;
  }
  private int date(String a) {
    return 1;
  }
  private int date(int a) {
    return 2;
  }



  @Test
  public void test() {
    assertThat(solution("?ab??a"), is("aabbaa"));
    assertThat(solution("?"), is("a"));
    assertThat(solution("bab??a"), is("NO"));
    assertThat(solution("?a?"), is("aaa"));
  }

}
