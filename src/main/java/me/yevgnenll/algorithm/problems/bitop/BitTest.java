package me.yevgnenll.algorithm.problems.bitop;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

import org.junit.jupiter.api.Test;

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

  @Test
  public void 정수가_주어졌을때_0하나를_1로_바꾸어_가장_길게_1이_연속으로_나오는_수를_반환하라() {
    int data = 1011110101;
    assertThat(convert1bit(data), is("111111"));
    assertThat(convert1bit(1001110101), is("11111"));
    assertThat(convert1bit(1000110111), is("111111"));
    assertThat(convert1bit(1111010111), is("111111"));
  }

  private String convert1bit(int data) {
    String[] d = String.valueOf(data).split("0");
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < d.length; i++) {
      if (d[i].length() > max) {
        max = d[i].length();
        maxIndex = i;
      }
    }
    String result = d[maxIndex];
    if (maxIndex < d.length-1 && d[maxIndex+1] != "") {
      result = d[maxIndex] + "1" + d[maxIndex+1];
    }
    if (maxIndex > 0 && d[maxIndex-1] != "") {
      String re = d[maxIndex-1] + "1" + d[maxIndex];
      if (result.length() < re.length()) {
        return re;
      }
    }
    return result;
  }



}
