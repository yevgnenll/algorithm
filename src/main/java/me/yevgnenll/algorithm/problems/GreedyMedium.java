package me.yevgnenll.algorithm.problems;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import javafx.util.Pair;

public class GreedyMedium {

    public int maxProfit(int[] prices) {
      int[] result = new int[prices.length - 1];
      int maxValue = 0;
      int total = 0;
      Map<Integer, Integer> map = new HashMap<>();

      Arrays.sort(prices);
      int max = prices[0];


      return 0;
    }

  public int[] sortByBits(int[] arr) {
    Pair<Integer, Integer>[] pairs = new Pair[arr.length];
    for (int i = 0 ; i < arr.length; i ++) {
      int n = arr[i];
      pairs[i] = new Pair<>(Integer.bitCount(n), n);
    }
    Arrays.sort(pairs,
        Comparator.comparing(Pair<Integer, Integer>::getKey)
            .thenComparing(Pair::getValue));
    return Stream.of(pairs).map(Pair::getValue).mapToInt(Integer::intValue).toArray();
  }


    @Test
    public void test() {
      int[] data = {1, 2, 3, 4, 5};
      assertThat(maxProfit(data), is(4));
      int[] data2 = {1,2,3,0,2};
      assertThat(maxProfit(data2), is(3));
    }

}
