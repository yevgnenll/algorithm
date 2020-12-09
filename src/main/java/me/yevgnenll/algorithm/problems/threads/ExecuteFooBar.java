package me.yevgnenll.algorithm.problems.threads;

public class ExecuteFooBar extends Thread {

  public ExecuteFooBar(String name) {
    this.name = name;
  }

  private String name;

  @Override
  public void run() {
    if ("first".equals(name)) {
      HasFooBar.foo(name);
    } else if ("second".equals(name)) {
      HasFooBar.bar(name);
    }
  }
}
