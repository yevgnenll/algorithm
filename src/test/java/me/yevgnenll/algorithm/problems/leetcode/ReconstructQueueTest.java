package me.yevgnenll.algorithm.problems.leetcode;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReconstructQueueTest {

  @Test
  void firstExample() {
    int[][] sample = new int[][] {
        {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
    };
    int[][] result = new int[][] {
        {5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}
    };
    ReconstructQueue reconstructQueue = new ReconstructQueue();
    assertThat(reconstructQueue.reconstructQueue(sample)).isEqualTo(result);

  }

  @Test
  void secondExample() {

    int[][] sample = new int [][] {
        {6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4}
    };

    int[][] result = new int[][] {
        {4,0}, {5,0}, {2,2}, {3,2}, {1,4}, {6,0}
    };
    ReconstructQueue reconstructQueue = new ReconstructQueue();
    assertThat(reconstructQueue.reconstructQueue(sample)).isEqualTo(result);

  }

}
