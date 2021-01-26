package me.yevgnenll.algorithm.problems.archive;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.jupiter.api.Test;



public class AlgoTest {

  private boolean hasDup(String a) {
    int r = a.charAt(0);

    for (int i = 1; i < a.length(); i ++) {
      int m = r;
      r ^= a.charAt(i);
      if (m > r) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void 문자열_중복_확인() {
    String a = "abcda";
    String b = "zbcffge";
    assertTrue(hasDup(a));
    assertTrue(hasDup(b));
  }

  private boolean hasPerm(String a, String b) {
    Set<Character> chars = new HashSet<>();
    if (a.length() != b.length()) {
      return false;
    }
    for (int i = 0; i < a.length(); i ++) {
      chars.add(a.charAt(i));
    }
    for (int i = 0; i < a.length(); i ++) {
      if (!chars.contains(b.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void 순열이_존재하는지_확인한다() {
    String a = "abcd";
    String b = "adcb";
    String c = "efgh";
    assertTrue(hasPerm(a, b));
    assertFalse(hasPerm(a, c));

  }

  private String convertTo(String c, int val) {
    StringBuilder re = new StringBuilder();
    for (int i = 0; i < val; i++) {
      if (" ".equals(String.valueOf(c.charAt(i)))) {
        re.append("%20");
      } else {
        re.append(c.charAt(i));
      }
    }
    return re.toString();
  }

  private char[] convertToWithChar(char[] c, int val) {
    int spaceCount = 0; int index = 0;
    for (int i = 0; i < val; i++) {
      if (c[i] == ' ') {
        spaceCount ++;
      }
    }
    index = val + spaceCount * 2;
    if (val < c.length) c[val] = '\0';
    for (int i = val - 1 ; i >= 0; i--) {
      if (c[i] == ' ') {
        c[index - 1] = '0';
        c[index - 2] = '2';
        c[index - 3] = '%';
        index -= 3;
      } else {
        c[index-1] = c[i];
        index --;
      }
    }


    return c;
  }

  @Test
  public void 문자열의_빈칸은_공백_인코딩을하여_반환한다() {
    String a = "Mr John Smith";
    char b[] = new char[3000];
    for (int i = 0; i < a.length(); i ++) b[i] = a.charAt(i);
    int val = 13;
    String r = "Mr%20John%20Smith";
    char re[] = new char[3000];
    for (int i = 0; i < r.length(); i ++) re[i] = r.charAt(i);
    assertThat(convertTo(a, val), is(r));
    assertThat(convertToWithChar(b, val), is(re));
  }

  private boolean hasPalindrome(String str) {
    str = str.toLowerCase();
    str = str.replaceAll("\\s+", "");
    int[] arr = new int['z' - 'a' + 1];
    for (int i = 0; i < str.length(); i ++) {
      char s = str.charAt(i);
      if (s < 97 || s > 122) continue;
      arr[s-97] += 1;
    }
    if (str.length() % 2 == 0) {
      for (int i = 0; i < arr.length ; i ++) {
        if (arr[i] % 2 != 0) {
          return false;
        }
      }
      return true;
    } else {
      int oddCount = 0;
      for (int i = 0; i < arr.length; i ++) {
        if (arr[i] == 1) oddCount += 1;
      }
      return oddCount == 1;
    }
  }

  @Test
  public void palindrome이고_순열_이면_true를_반환한다() {
    assertThat(hasPalindrome("Tact coa"), is(true));
  }

  private boolean isLessThanEqualsOne(String str, String str2) {
    int count = 0;
    if (str.length() != str2.length()) {
      count += Math.abs(str.length() - str2.length());
    }
    for (int i = 0; i < Math.max(str.length(), str2.length()); i ++) {
      if (i < str.length() && i < str2.length() && str.charAt(i) != str2.charAt(i)) {
        count += 1;
        continue;
      }
    }
    return count <= 1;
  }

  @Test
  public void 두개의_문자열을_같게_만들려면_편집_횟수가_1회_이내인가() {
    assertThat(isLessThanEqualsOne("pale", "ple"), is(true));
    assertThat(isLessThanEqualsOne("pales", "pale"), is(true));
    assertThat(isLessThanEqualsOne("pale", "bale"), is(true));
    assertThat(isLessThanEqualsOne("pale", "bake"), is(false));
  }

  @Test
  public void 스택의_최소값이_가장_위로_올라오도록_정렬한다() {
    Stack<Integer> testCase = new Stack<>();
    testCase.push(5);
    testCase.push(7);
    testCase.push(8);
    testCase.push(1);
    testCase.push(6);
    testCase.push(3);
    SortStack sortStack = new SortStack(testCase);

    Stack<Integer> result = new Stack<>();
    result.push(8);
    result.push(7);
    result.push(6);
    result.push(5);
    result.push(3);
    result.push(1);

    assertThat(sortStack.get(), is(result));
  }

  private int[][] matrixConvert(int[][] matrix) {
    int x = 0, y = 0;
    for (int i = 0; i < matrix.length; i ++) {
      for (int j = 0; j < matrix[i].length; j ++) {
        if (matrix[i][j] == 0) {
          x = i;
          y = j;
          break;
        }
      }
    }
    for (int i = 0; i < matrix.length; i ++) {
      matrix[i][y] = 0;
    }
    for (int i = 0; i < matrix[x].length; i ++) {
      matrix[x][i] = 0;
    }
    return matrix;
  }

  @Test
  public void 행렬_MxN_에서_0이_있는_행과_열을_모두_0으로_바꾼다() {
    int[][] matrix = {
        {1, 2, 3, 4, 5, 6, 7},
        {2, 4, 5, 6, 7, 8, 9},
        {7, 4, 6, 2, 0, 4, 5},
        {1, 4, 9, 2, 9, 4, 5}
    };

    int[][] result = {
        {1, 2, 3, 4, 0, 6, 7},
        {2, 4, 5, 6, 0, 8, 9},
        {0, 0, 0, 0, 0, 0, 0},
        {1, 4, 9, 2, 0, 4, 5}
    };

    assertThat(matrixConvert(matrix), is(result));
  }

  @Test
  public void 행렬_NxN이_입력되면_오른쪽으로_90도_회전시켜_반환하라() {

  }

}
