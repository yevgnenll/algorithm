package me.yevgnenll.algorithm.problems;

import java.util.ArrayList;
import java.util.List;

public class FindDisappear {
  public static void main(String args[]) {
    FindDisappear f = new FindDisappear();
    int[] ex = {4,3,2,7,8,2,3,1};
    List<Integer> re = f.findDisappearedNumbers(ex);
    for (int an : re) {
      System.out.println(an);
    }
  }
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
      int indexValue = Math.abs(num) - 1;
      if (nums[indexValue] > 0) {
        nums[indexValue] = -nums[indexValue];
      }
    }
    for (int i = 0; i < nums.length; i ++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }

    }
    return result;
  }

}
