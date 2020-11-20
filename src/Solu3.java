import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

public class Solu3 {

  public int solution(String S) {
    if (S.length() == 0) return 0;

    int[] front = new int[S.length()];
    int[] back = new int[S.length()];

    char[] s = S.toCharArray();
    int length = S.length();

    Collections.singletonList(1);
    if(s[0] == 'B') {
      front[0] = 1;
    }
    if(s[length - 1] == 'A') {
      back[S.length() - 1] = 1;
    }

    for(int i = 1; i < length ; i ++) {
      front[i] = front[i - 1] + (s[i] == 'B' ? 1 : 0);
    }

    for(int i = length - 2; i >= 0 ; i --) {
      back[i] = back[i + 1] + (s[i] == 'A' ? 1 : 0);
    }

    int min = Integer.MAX_VALUE;

    for(int i = 0; i < length - 1 ; i ++) {
      if(front[i] != front[i + 1]) {
        min = Math.min(min, front[i] + back[i + 1]);
      }
    }

    min = Math.min(min, front[S.length() - 1]);

    for(int i = length - 1; i > 0 ; i --) {
      if(back[i] != back[i - 1]) {
        min = Math.min(min, back[i] + front[i - 1]);
      }
    }

    min = Math.min(min, back[0]);
    return min;
  }

  @Test
  public void test() {
//    assertThat(solution("BAAABAB"), is(2));
    assertThat(solution("BBBBBBBBA"), is(1));
//    assertThat(solution(""), is(0));
  }
}
