package bitop;

import org.junit.Test;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BitTest {

  @Test
  public void 두개_비트를_i_j_에_삽입한다() {
    int m = 0b10000000000;
    int n = 0b10011;
    System.out.println("m : " + m + ", n: " + n + ", result: "+ 0b10001001100);
    int i = 2;
    int j = 6;
    int result = bitInsert(m, n, i, j);
    assertThat(result, is(0b10001001100));
    assertThat(bitInsert(0b11111111111, 0b10011, 2, 6), is(0b11111001111));
  }

  public int bitInsert(int m, int n, int i, int j) {
    m = bitDeleteFrom(m, j, i);
    n = leftBitShift(n, i);
    System.out.println("m: " + Integer.toBinaryString(m) + ", n: " + Integer.toBinaryString(n)
        + ", m + n: " + Integer.toBinaryString(m+n));
    return m + n;
  }

  private int bitDeleteFrom(int num, int start, int end) {
    int mask = (1 << (start + 1)) - 1;
    mask = mask >> end;
    mask = mask << end;
    return num & ~mask;
  }
  private int leftBitShift(int num, int j) {
    return num << j;
  }
}
