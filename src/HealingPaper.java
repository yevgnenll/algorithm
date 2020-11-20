import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.*;

public class HealingPaper {

  public static void main(String[] args) {

    convertStringToInteger("12r34");

  }

  public static List<Integer> listRotation(List<Integer> list, int count) {
    List<Integer> result = new ArrayList<>();
    int size = list.size();
    int cut = getFinalRotationCount(list.size(), count);
    if (count == 0 ) {
      return list;
    } else if (count > 0) {
      List<Integer> first = list.subList(cut, size);
      List<Integer> last = list.subList(0, cut);
      result.addAll(first);
      result.addAll(last);
    } else {
      List<Integer> first = list.subList(size - cut, size);
      List<Integer> last = list.subList(0, size - cut);
      result.addAll(first);
      result.addAll(last);
    }
    return result;
  }

  private static int getFinalRotationCount(int size, int count) {
    return Math.abs(count % size);
  }

  @Test
  public void 예시에_양수_count_리스트로_검증한다() {
    List<Integer> list = new ArrayList<> (
        Arrays.asList(1, 2, 3, 4, 5)
    );
    List<Integer> result = new ArrayList<> (
        Arrays.asList(3, 4, 5, 1, 2)
    );
    assertEquals(result, listRotation(list, 2));
  }

  @Test
  public void 예시의_음수_count_리스트를_검증한다() {
    List<Integer> list = new ArrayList<> (
        Arrays.asList(1, 2, 3, 4, 5)
    );

    List<Integer> result = new ArrayList<> (
        Arrays.asList(5, 1, 2, 3, 4)
    );
    assertEquals(result, listRotation(list, -1));
  }

  @Test
  public void 예시의_size보다_큰_count_리스트를_검증한다() {
    List<Integer> list = new ArrayList<> (
        Arrays.asList(1, 2, 3, 4, 5)
    );

    List<Integer> result = new ArrayList<> (
        Arrays.asList(4, 5, 1, 2, 3)
    );
    assertEquals(result, listRotation(list, 8));
  }


  @Test
  public void count의_숫자가_리스트_size보다_클_경우_필요한_횟수만큼_rotation_하는_값을_반환한다() {
    assertEquals(3, getFinalRotationCount(5, 8));
    assertEquals(2, getFinalRotationCount(5, 2));
    assertEquals(-1, getFinalRotationCount(5, -1));
  }




  public static int convertStringToInteger(String str) {
    char[] s = str.toCharArray();
    String appendedChar = "";
    int plusOrMinus = 1;
    if (isMinusInteger(s[0])) {
      plusOrMinus *= -1;
    }
    if (isInteger(s[0])) {
      appendedChar += String.valueOf(s[0]);
    }
    for (int i = 1; i < s.length ; i ++) {
      char c = s[i];
      if (isInteger(c)) {
        appendedChar += String.valueOf(c);
      }
    }

    return Integer.parseInt(appendedChar) * plusOrMinus;
  }
  private static boolean isInteger(char c) {
    // ascii 0~47, 58~ 은 숫자에 해당하지 않는다.
    return c >= 48 && c <= 57;
  }
  private static boolean isMinusInteger(char c) {
    return c == 45;
  }

  @Test
  public void 숫자가_아닌_값이_포함되면_숫자를_제외하고_반환한다() {
    assertEquals(1234, convertStringToInteger("12r34"));
  }
}
