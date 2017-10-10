public class KnightChess {
  public static void main(String args[]) {
  }

  public double knightProbability(int N, int K, int r, int c) {
    int[][] areas = getAvailableAreaCounts(r, c);

  }
  private int[][2] getMovableAreas(int r, c) {
    return new int[][2]{
        {r + 1, c + 2},
        {r + 2, c + 2},
        {r + 1, c - 2},
        {r + 2, c - 2},
        {r - 1, c + 2},
        {r - 2, c + 2},
        {r - 1, c - 2},
        {r - 2, c - 2}
    }
  }
  private int getAvailableAreaCounts(int[][2] areas) {
    int movableAreaCount = 0;
    for (int[] area : areas) {
      if (avaliableSeat(area)) movableAreaCount += 1;
    }
    return movableAreaCount;
  }

  private int[][2] getNotOffAreas(int[][2] areas) {
    int[][2] result = new int[][2];
    for (int area : areas) {
      if (avaliableSeat(area)) {
        result.add(area)
      }
    }
    return result;
  }

  private boolean avaliableSeat(int[2] area) {
    return area[0] >= 0 && area[1] >= 0;
  }
}
