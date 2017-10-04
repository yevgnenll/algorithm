import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosest {
  public static void main(String args[]) {
    FindKClosest f = new FindKClosest();
    int[] arr = {0,0,0,1,3,5,6,7,8,8};
    int k = 2;
    int x = 2;
    List<Integer> result = f.findClosestElements(arr, k, x);
    System.out.println(result);
  }
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> convertedList = convertToList(arr);
    if (convertedList.size() == 1) {
      return convertedList;
    }
    List<Integer> minusAbs = minusAbsElements(arr, x);
    int minIndex = getMinIndex(minusAbs);
    int startIndex = minIndex - (k / 2);
    return convertedList.subList(startIndex, startIndex + k);

  }

  private List<Integer> minusAbsElements(int[] arr, int target) {
    List<Integer> result = new ArrayList<>();
    for (int number : arr) {
      int minus = number - target;
      result.add(Math.abs(minus));
    }
    return result;
  }

  private int getMinIndex(List<Integer> arr) {
    return arr.indexOf(Collections.min(arr));
  }

  private boolean isLengthEven(List<Integer> arr) {
    return arr.size() % 2 == 0;
  }

  private List<Integer> convertToList(int[] arr) {
    List<Integer> result = new ArrayList<>();
    for (int number : arr) {
      result.add(number);
    }
    return result;
  }
}
