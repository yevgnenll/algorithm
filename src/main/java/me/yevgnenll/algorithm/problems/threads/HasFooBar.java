package me.yevgnenll.algorithm.problems.threads;

public class HasFooBar {

  public static synchronized void foo(String name) {
    try {
      System.out.println("thread " + name + ".foo(): starting");
      Thread.sleep(3000);
      System.out.println("thread " + name + ".foo(): ending");
    } catch (InterruptedException ex) {
      System.out.println("thread " + name + ": interrupted: ");
    }
  }

  public static synchronized void bar(String name) {
    try {
      System.out.println("thread " + name + ".bar(): starting");
      Thread.sleep(3000);
      System.out.println("thread " + name + ".bar(): ending");
    } catch (InterruptedException ex) {
      System.out.println("thread " + name + ": interrupted: ");
    }
  }
}
