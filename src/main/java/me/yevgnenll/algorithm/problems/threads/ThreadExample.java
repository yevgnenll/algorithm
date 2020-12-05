package me.yevgnenll.algorithm.problems.threads;

import lombok.Getter;

public class ThreadExample extends Thread {

  @Getter
  private int count = 0;

  @Override
  public void run() {
    System.out.println("thread string.");
    try {
      while(count < 5) {
        Thread.sleep(500);
        System.out.println("In thread, count is " + count);
        count ++;
      }
    } catch (InterruptedException ex) {
      System.out.println("Thread interrupted");
    }
    System.out.println("thread terminating");
  }
}
