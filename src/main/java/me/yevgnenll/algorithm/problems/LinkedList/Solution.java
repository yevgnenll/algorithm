package me.yevgnenll.algorithm.problems.LinkedList;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Objects;
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

  @Test
  @DisplayName("처음과 끝 노드를 제외하고 중간 노드 하나를 삭제하라")
  public void deleteMiddleNodeTest() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] deleted = {1, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] length2 = {1, 2};
    Node sample = makeSample(arr);
    Node deletedNode = makeSample(deleted);
    Node length2Node = makeSample(length2);

    assertThat(deleteMiddleNode(sample)).isEqualTo(deletedNode);
    assertThat(deleteMiddleNode(length2Node)).isEqualTo(makeSample(length2));
  }

  @Test
  @DisplayName("연결리스트의 합을 구하라 숫자는 역순으로 배치되어 있으며, 반환도 연결리스트로 반환한다")
  public void sumLinkedListTest() {
    Node a = makeSample(new int[] {7, 1, 6});
    Node b = makeSample(new int[] {2, 9, 5});
    Node result = makeSample(new int[] {9, 1, 2});

    assertThat(sumLinkedList(a, b)).isEqualTo(result);
  }

  public Node sumLinkedList(Node a, Node b) {
    int sum = a.getData() + b.getData();
    int op = 0;
    if (sum / 10 > 1) {
      sum -= (sum / 10) * 10;
      op = sum / 10;
    }
    while (a.hasNext() && b.hasNext()) {

    }
    return null;
  }

  private int convertToInt(Node head) {
    StringBuffer str = new StringBuffer(head.getData());
    while (head.hasNext()) {
      head = head.getNext();
      str.append(head.getData());
    }
    return Integer.parseInt(str.reverse().toString());
  }

  public Node deleteMiddleNode(Node node) {
    if (Objects.isNull(node)) {
      return null;
    }
    int length = 1;
    Node calculate = node;
    while (calculate.hasNext()) {
      calculate = calculate.getNext();
      length++;
    }
    if (length == 2)
      return node;

    Node next = node.getNext();
    node.next = next.getNext();

    return node;
  }

  public int findFromKthElement(Node node, int k) {
    Node kth = null;
    Node head = node;
    while (node.hasNext()) {
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
    for (int i = 0; i < k; i++) {
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
    while (node.hasNext()) {
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
