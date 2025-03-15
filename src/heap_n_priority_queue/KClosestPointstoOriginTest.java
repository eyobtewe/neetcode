package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KClosestPointstoOriginTest {

   @Test
   void kClosest() {
//      [2,2],[2,2],[2,2],[2,2],[2,2],[2,2],[1,1]
      assertEquals(1, KClosestPointstoOrigin.kClosest(
            new int[][]{{2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {1, 1}}, 2)
      );
   }
}