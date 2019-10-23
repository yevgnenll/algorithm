import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MovingKnight {

  public double knightProbability(int N, int K, int r, int c) {
    return 0;
  }

  @Test
  public void NKrc에_각각_3200를_입력하면_0_0625를_반환한다() {
    assertThat(0.0625, is(knightProbability(3, 2, 0, 0)));
  }
}
