package backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumTest {

   @Test
   void combinationSum() {
      assertEquals(2, CombinationSum.combinationSum(new int[]{2, 5, 6, 9}, 9).size());
      assertEquals(4, CombinationSum.combinationSum(new int[]{3,4,5}, 16).size());
      assertEquals(0, CombinationSum.combinationSum(new int[]{3}, 5).size());
   }
}