import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class LongestSubString {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> indexByWord = new HashMap<>();
    int distance = 1;
    int max = 1;
    indexByWord.put(s.charAt(0), 0);
    for (int i = 0; i < s.length(); i ++) {
      char lastWord = s.charAt(i);
      distance = indexByWord.containsKey(lastWord) ? Math.min(i - indexByWord.get(lastWord), distance + 1) : distance + 1;
      max = Math.max(distance, max);
      indexByWord.put(lastWord, i);
    }
    return max;
  }

  @Test
  public void 테스트_케이스_abcabcabz의_값은_4_이다() {
    int result = this.lengthOfLongestSubstring("abcabcabz");
    assertThat(4, is(result));
  }

  @Test
  public void 테스트_케이스_aabcdzabc의_결과는_5_이다() {
    int result = this.lengthOfLongestSubstring("aabcdzabc");
    assertThat(5, is(result));
  }
}
