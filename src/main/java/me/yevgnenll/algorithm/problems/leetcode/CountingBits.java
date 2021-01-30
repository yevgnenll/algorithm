package me.yevgnenll.algorithm.problems.leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

  public int[] countBits(int num) {
    int[] result = new int[num+1];

    for (int i = 0; i < num+1 ; i++) {
      result[i] = result[i>>1] + i & 1;
    }
    return result;
  }

}
