import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    Map<Integer, List<Integer>> minusAbs = minusAbsElements(arr, x);
    return getSortedMapList(minusAbs, k);
  }

  private Map<Integer, List<Integer>> minusAbsElements(int[] arr, int target) {
    Map<Integer, List<Integer>> result = new TreeMap<>();
    for (int number : arr) {
      int minusAbs = Math.abs(number - target);
      if (!result.containsKey(minusAbs)) result.put(minusAbs, new LinkedList<>());
      result.get(minusAbs).add(number);
    }
    return result;
  }

  /*
  * 여기서 abs를 key로 갖고 해당 abs를 갖는 element를 list로 하여 value로 갖는다
  * 따라서 기존의 minIndex도 필요하지 않다
  * 가장 첫번째 element의 key(abs minus)와 element가 답이기 때문
  * */
  private List<Integer> getSortedMapList(Map<Integer, List<Integer>> absMap, int size) {
    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> entry : absMap.entrySet()) {
      for (int value : entry.getValue()) {
        result.add(value);
        if (result.size() == size) break;
      }
      if (result.size() == size) break;
    }
    Collections.sort(result);
    return result;
  }

  private List<Integer> convertToList(int[] arr) {
    List<Integer> result = new ArrayList<>();
    for (int number : arr) {
      result.add(number);
    }
    return result;
  }
}
