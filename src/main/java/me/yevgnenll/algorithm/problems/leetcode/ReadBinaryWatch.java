package me.yevgnenll.algorithm.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 */
public class ReadBinaryWatch {

  public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<>();
    for (int h = 0; h <12; h ++) {
      for (int m = 0; m < 60; m ++) {
        int count = Integer.bitCount(h) + Integer.bitCount(m);
        if (count == num)
          result.add(String.format("%d:%02d", h, m));
      }
    }
    return result;
  }

}
