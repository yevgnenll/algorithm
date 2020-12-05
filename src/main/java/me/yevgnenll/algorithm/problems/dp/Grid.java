package me.yevgnenll.algorithm.problems.dp;

public class Grid {

  public int grid(int r, int c) {
    if (r == 1 && c == 1) return 1;
    if (r == 1 || c == 1) return 1;

    return 0;
  }
}
