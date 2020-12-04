package me.yevgnenll.algorithm.problems;

public class MovingKnight {
  private double[][] board = null;

  /*
  public double knightProbability(int N, int K, int r, int c) {
    if (board == null) {
      board = new double[N][N];
      for (double a[] : board) {
        Arrays.fill(a, -1.0);
      }
    }
    double[] d = new double[] { 1, 2 };

  }

  private List<double[]> getLocations(int n, int r, int c) {
    List<double[]> result = new ArrayList<>();
    result.add(new double[] {r - 2, c - 1});
    result.add(new double[] {r - 1, c - 2});
    result.add(new double[] {r + 1, c - 2});
    result.add(new double[] {r + 2, c - 1});
    result.add(new double[] {r - 2, c + 1});
    result.add(new double[] {r - 1, c + 2});
    result.add(new double[] {r + 2, c + 1});
    result.add(new double[] {r + 1, c + 2});
    List<double[]> notSatisfied = new ArrayList<>();
    int max = n - 1;
    int min = 0;
    for (double[] location : result) {
      if ((location[0] < min || location[0] > max) || location[1] < min || location[1] > max) {
        notSatisfied.add(location);
      }
    }
    result.removeAll(notSatisfied);
    return result;
  }

  // 한 점에서의 확률
  private double possibility(int N, int r, int c, ) {
    List<double[]> locations = this.getLocations(N, r, c);
    if (board[r][c] < 0.0) {
      for (double[] location : locations) {

      }
    }
    return board[r][c];
  }

  @Test
  public void NKrc에_각각_3200를_입력하면_0_0625를_반환한다() {
    assertThat(0.0625, is(knightProbability(3, 2, 0, 0)));
  }

     */
}
