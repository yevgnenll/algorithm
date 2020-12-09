package me.yevgnenll.algorithm.problems.archive;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String args[]) {
    int[] a = {-3,4,3,90};
    int target = 0;
    TwoSum t = new TwoSum();
    int[] r = t.twoSum(a, target);
    System.out.println(r.toString());
  }
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> mappedNumes = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i ++) {
      int num = nums[i];
      if (mappedNumes.containsKey(target - num)) {
        result[0] = mappedNumes.get(target - num);
        result[1] = i;
        return result;
      }
      mappedNumes.put(nums[i], i);

    }
    return result;
  }

}
