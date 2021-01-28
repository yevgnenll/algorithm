package me.yevgnenll.algorithm.problems.leetcode;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReadBinaryWatchTest {

  private ReadBinaryWatch solution = new ReadBinaryWatch();

  @Test
  void aboutBitCount() {
    // integer 10진수를 2진수로 변경했을때 거기서 1의 개수를 세어준다
    // ㅎㄷㄷ 이걸 진작에 알았더라면 ㅠ
    assertThat(Integer.bitCount(12)).isEqualTo(2);
    assertThat(Integer.bitCount(13)).isEqualTo(3);
  }

  @Test
  void not12Hours() {

    String[] answer = new String[] {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20",
        "0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01",
        "2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00",
        "6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
    List<String> converted = convertToList(answer);
    assertThat(solution.readBinaryWatch(2)).isEqualTo(converted);
  }

  private List<String> convertToList(String[] arr) {
    return Arrays.asList(arr);
  }

  @Test
  void whenNumIs1() {

    String[] answer = new String[]{
        "0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"
    };
    List<String> result = convertToList(answer);

    assertThat(solution.readBinaryWatch(1)).isEqualTo(result);

  }

}
