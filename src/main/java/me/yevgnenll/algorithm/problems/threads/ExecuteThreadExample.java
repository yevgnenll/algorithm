package me.yevgnenll.algorithm.problems.threads;

public class ExecuteThreadExample {
  public static void main(String[] args) {
    ThreadExample instance = new ThreadExample();
    instance.start();
    while (instance.getCount() != 5) {
      try {
        System.out.println("waiting..");
        Thread.sleep(250);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
}
