package me.yevgnenll.algorithm.problems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class FindDistance {

  public int solution(int[] a) {
    // k: position , v: index
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < a.length ; i ++) {
      if (!map.containsKey(a[i])) {
        map.put(a[i], i);
      } else {
        return 0;
      }
    }

    int min = Integer.MAX_VALUE;
    Integer[] positions = map.keySet().toArray(new Integer[map.size()]);
    for (int i = 1; i < positions.length ; i ++) {
      int previousIndex = map.get(positions[i-1]);
      int distance = positions[i] - positions[i - 1];
      if (previousIndex < i && (min > distance)) {
        min = distance;
      }
    }
    return min;
  }

  @Test
  public void test() {
    int[] a = {0, 3, 3, 7, 5, 3, 11, 1};
    assertEquals(0, solution(a));


    int[] b = {0, 3, 6, 13, 5, 11, 1};
    assertEquals(1, solution(b));
  }

}
