package me.yevgnenll.algorithm.problems.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subset {
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> empty = Collections.emptyList();
    List<List<Integer>> result = new ArrayList<>();
    result.add(empty);

    for (int i = 0; i < nums.length; ++ i) {
      List<List<Integer>> list = gen(result, nums[i]);
      for (List<Integer> item : list) {
        result.add(item);
      }
    }
    return result;
  }

  // 자기 자신을 저장하고,
  // result를 돌면서 add 한것을 result로 반환한다.
  private List<List<Integer>> gen(List<List<Integer>> list, int num) {
    List<List<Integer>> ns = new ArrayList<>();
    ns.add(new ArrayList() {{
      add(num);
    }});
    for (int i = 1; i < list.size(); i ++) {
      List<Integer> item = new ArrayList<>(list.get(i));
      item.add(num); // 복사가 일어나는건가?
      ns.add(item);
    }
    return ns;
  }

}
