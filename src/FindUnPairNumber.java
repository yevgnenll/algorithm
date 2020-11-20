import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class FindUnPairNumber {

  public int solution(int[] a) {
    int res = 0;
    for (int n : a) {
      res = n ^ res;
    }
    return res;
  }

  @Test
  public void 반환값은_7_이다() {
    int[] a = {9, 3, 9, 3, 9, 7, 9};
    assertEquals(7, solution(a));
  }
}

