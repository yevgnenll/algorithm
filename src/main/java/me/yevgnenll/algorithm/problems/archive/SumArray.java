package me.yevgnenll.algorithm.problems.archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SumArray {

  public int solution(List<Integer> array, int target) {

    int max = 0;
    int size = 0;
    this.getLength(array, target);
    for (int i = 0 ; i < array.size() ; i++) {
      List<Integer> slicedList = array.subList(i, array.size());
      size = this.getLength(slicedList, target);
      if (max < size) {
        max = size;
      }
    }
    return max;
  }

  private int getLength (List<Integer> array, int target) {
    int sum = 0;
    int max = 0;

    for (int i = 0 ; i < array.size() ; i++) {
      int current = array.get(i);
      sum += current;
      if (sum == target && max < i + 1) {
        max = i + 1;
      }
    }
    return max;
  }

  private int sumAllArrayList(List<Integer> array) {
    return array.stream().reduce((a,b)->a+b).get();
  }

  private boolean isLongestArray(int originArrayLength, int slicedArrayLength) {
    return originArrayLength == slicedArrayLength;
  }

  public static void main(String args[]) {
    SumArray s = new SumArray();
    List<Integer> array = new ArrayList<>(
//        Arrays.asList(1, 0, -1, 0, 0, 1, 1)
//        Arrays.asList(1, 0, -1, 1, 1, -1, -1)
//        Arrays.asList(1, 0, -1, 1, 1, -1, -1)
        Arrays.asList(1, 0, -1, 1, 1, 0, 0, -1, -1)
    );
    System.out.println(s.solution(array, 2));
  }

}
