package me.yevgnenll.algorithm.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1) return intervals;

    Arrays.sort(intervals, (a, b)  -> a[0] - b[0]);

    List<Integer[]> merge = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 0; i < intervals.length; i ++) {
      int[] range = intervals[i];
      if (end < range[0]) {

        merge.add(new Integer[] {start, end} );
        start = range[0];
        end = range[1];

      } else {
        start = Math.min(start, range[0]);
        end = Math.max(end, range[1]);
      }
    }
    merge.add(new Integer[] { start, end });
    int[][] result = new int[merge.size()][2];
    for (int i = 0; i < merge.size(); i ++) {
      result[i] = new int[] {merge.get(i)[0], merge.get(i)[1]};
    }
    return result;
  }

}
