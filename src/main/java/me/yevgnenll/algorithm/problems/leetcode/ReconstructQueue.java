package me.yevgnenll.algorithm.problems.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class ReconstructQueue {

  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (o1, o2) ->
        o1[0] != o2[0] ? - o1[0] + o2[0] : o1[1] - o2[1]
    );

    LinkedList<int[]> list = new LinkedList<>();
    for (int i = 0; i < people.length; i++)
      list.add(people[i][1], people[i]);
    return people;
  }

}
