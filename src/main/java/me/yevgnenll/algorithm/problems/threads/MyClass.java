package me.yevgnenll.algorithm.problems.threads;

public class MyClass extends Thread {

  private String name;
  private MyObject myObject;

  public MyClass(MyObject obj, String name) {
    this.myObject = obj;
    this.name = name;
  }

  @Override
  public void run() {
    myObject.foo(name);
  }
}
