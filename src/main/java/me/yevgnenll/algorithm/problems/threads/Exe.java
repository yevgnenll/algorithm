package me.yevgnenll.algorithm.problems.threads;

public class Exe {
  public static void main(String[] args) {
    ExecuteFooBar ob1 = new ExecuteFooBar("first");
    ExecuteFooBar ob2 = new ExecuteFooBar("second");
    ob1.start();
    ob2.start();
  }
}
