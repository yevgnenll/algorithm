import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DistinctSubseqII {

  public int distinctSubseqII(String S) {
    if (S.length() == 0) {
      return 0;
    }
    long[] endWith = new long[26];
    long mod = (long) 1e9 + 7;
    Arrays.fill(endWith, 0);
    endWith[S.charAt(0) - 'a'] = 1;
    for(int i = 1; i < S.length(); i ++) {
      char s = S.charAt(i);
      int index = s - 'a';
      long previousDp = Arrays.stream(endWith).sum() % mod;
      endWith[index] = previousDp + 1;
    }
    return (int) (Arrays.stream(endWith).sum() % mod) ;
  }

  @Test
  public void pcrdhwdxmqdznbenhwjsenjhvulyve를_입력하면_결고는_이다() {
    System.out.println(distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
  }

  @Test
  public void abc를_입력하면_7이_결과로_나온다() {
    assertThat(7, is(distinctSubseqII("abc")));
  }

  @Test
  public void aba를_입력하면_결과는_6이다() {
    assertThat(6, is(distinctSubseqII("aba")));
  }

  @Test
  public void aaa를_입력하면_결과는_3이다() {
    assertThat(3, is(distinctSubseqII("aaa")));
  }

  @Test
  public void lee를_입력하면_결과는_5이다() {
    assertThat(5, is(distinctSubseqII("lee")));
  }

  @Test
  public void zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn를_입력하면_97915677를_반환한다() {
    assertThat(97915677, is(distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn")));
  }

}
