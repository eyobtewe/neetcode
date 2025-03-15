package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

   @Test
   public void testLastStoneWeight() {
      // Test case 1: General case
      assertEquals(1, LastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));

      // Test case 2: Single stone
      assertEquals(5, LastStoneWeight.lastStoneWeight(new int[]{5}));

      // Test case 3: Two equal stones
      assertEquals(0, LastStoneWeight.lastStoneWeight(new int[]{3, 3}));

      // Test case 4: All stones cancel out
      assertEquals(0, LastStoneWeight.lastStoneWeight(new int[]{4, 4, 4, 4}));

      // Test case 5: Already sorted descending
      assertEquals(3, LastStoneWeight.lastStoneWeight(new int[]{10, 5, 2}));

      // Test case 6: Empty array
      assertEquals(0, LastStoneWeight.lastStoneWeight(new int[]{}));

      // Test case 7: Large numbers
      assertEquals(999999, LastStoneWeight.lastStoneWeight(new int[]{1000000, 1}));

      // Test case 8: Only two stones, different weight
      assertEquals(1, LastStoneWeight.lastStoneWeight(new int[]{7, 8}));
   }
}