package me.yevgnenll.algorithm.problems.threads;

public class RunnableThreadExample implements Runnable {
  private int count = 0;

  @Override
  public void run() {
    System.out.println("Runnable thread starting");
    try {
      while (count < 5) {
        Thread.sleep(500);
        count ++;
        System.out.println("count up: " + count);
      }
    } catch (InterruptedException ex) {
      System.out.println("runnable thread interrupted.");
    }
    System.out.println("runnable thread terminating.");
  }

  public static void main(String[] args) {
    RunnableThreadExample instance = new RunnableThreadExample();
    Thread thread = new Thread(instance);
    thread.start();

    while(instance.count != 5) {
      try {
        Thread.sleep(500);
        System.out.println("waiting");
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
}
