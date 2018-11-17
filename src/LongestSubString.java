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
    int distance = 1; // 무조건 1자리는 있다.
    int max = 1; // 1자리가 있기 때문에 max는 1부터 시작한다.
    Map<Character, Integer> indexByCharacter = new HashMap<>();
    indexByCharacter.put(s.charAt(0), 0);
    for (int currentPosition = 1; currentPosition < s.length(); currentPosition ++) {
      char currentCharacter = s.charAt(currentPosition);
      distance = indexByCharacter.containsKey(currentCharacter) ?
          Math.min(currentPosition - indexByCharacter.get(currentCharacter), distance + 1) : distance + 1;
      max = Math.max(distance, max);
      indexByCharacter.put(currentCharacter, currentPosition);
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
