package me.yevgnenll.algorithm.problems.threads;

public class MyExamSame {
  public static void main(String[] args) {
    // foo 를 가지고 있음
    MyObject obj = new MyObject();

    // foo 호출
    MyClass thread1 = new MyClass(obj, "first");
    MyClass thread2 = new MyClass(obj, "second");

    thread1.start();
    thread2.start();
  }
}
