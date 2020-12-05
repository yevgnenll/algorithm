package me.yevgnenll.algorithm.problems.threads;

public class MyObject {
  public synchronized void foo(String name) {
    try {
      System.out.println("thread " + name + ".foo(): starting");
      Thread.sleep(3000);
      System.out.println("thread " + name + ".foo(): ending");
    } catch (InterruptedException ex) {
      System.out.println("thread " + name + ": interrupted: ");
    }
  }
}
