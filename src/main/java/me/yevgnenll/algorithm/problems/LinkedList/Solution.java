package me.yevgnenll.algorithm.problems.LinkedList;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.yevgnenll.algorithm.structure.Node;

public class Solution {

  @Test
  @DisplayName("linkedList 내에 중복 되는 원소를 제거한다")
  public void removeDuplicateTest() {
    int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
    Node sample = makeSample(arr);

    assertThat(removeDuplicate(sample)).isEqualTo(5);
  }

  @Test
  @DisplayName("set 과 같은 추가 공간을 사용하지 않고 LinkedList 의 중복을 제거하라")
  public void removeDuplicateWithoutSpaceTest() {
    int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
    Node sample = makeSample(arr);
    assertThat(removeDuplicateWithoutSpace(sample)).isEqualTo(5);
  }

  @Test
  @DisplayName("뒤에서 k 번째 원소 반환하기")
  public void findFromKthElementTest() {
    int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
    Node sample = makeSample(arr);

    assertThat(findFromKthElement(sample, 3)).isEqualTo(7);
    assertThat(findFromKthElementEnhance(sample, 4)).isEqualTo(6);
  }

  public int findFromKthElement(Node node, int k) {
    Node kth = null;
    Node head = node;
    while(node.hasNext()) {
      if (k == 0) {
        kth = head.getNext();
      } else if (k < 0) {
        kth = kth.getNext();
      }
      node = node.getNext();
      k--;
    }
    return kth.getData();
  }

  public int findFromKthElementEnhance(Node node, int k) {
    Node p1 = node;
    Node p2 = node;
    for (int i = 0; i < k; i ++) {
      p1 = p1.getNext();
    }
    while (p1.hasNext()) {
      p1 = p1.getNext();
      p2 = p2.getNext();
    }
    return p2.getData();
  }

  private int removeDuplicateWithoutSpace(Node node) {
    int cal = node.getData();
    node = node.getNext();
    while (node.hasNext()) {
      int xor = cal ^ node.getData();
      if (xor == 0) {
        return node.getData();
      }
      cal = node.getData();
      node = node.getNext();
    }
    return cal;
  }

  private int removeDuplicate(Node node) {
    Set<Integer> value = new HashSet<>();
    while(node.hasNext()) {
      if (value.contains(node.getData())) {
        return node.getData();
      } else {
        value.add(node.getData());
      }
      node = node.getNext();
    }
    return -1;
  }

  private Node makeSample(int[] arr) {
    Node sample = new Node(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      sample.appendToTail(arr[i]);
    }
    return sample;
  }

}
