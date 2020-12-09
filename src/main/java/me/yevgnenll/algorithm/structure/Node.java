package me.yevgnenll.algorithm.structure;

public class Node {
  private Node next = null;
  private int data;
  public Node(int d) {
    this.data = d;
  }
  public Node appendToTail(int d) {
    Node head = this;
    Node end = new Node(d);
    Node n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = end;
    return head;
  }

  public boolean hasNext() {
    return next != null;
  }

  public int getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }
}
