package me.yevgnenll.algorithm.problems.threads;

public class MyExamDifferent {

  public static void main(String[] args) {
    MyObject obj1 = new MyObject();
    MyObject obj2 = new MyObject();
    MyClass thread1 = new MyClass(obj1, "first");
    MyClass thread2 = new MyClass(obj2, "second");
    thread1.start();
    thread2.start();
  }
}
