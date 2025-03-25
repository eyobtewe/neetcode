package backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumTwoTest {

   @Test
   void combinationSumTwo() {
      assertEquals(3, CombinationSumTwo.combinationSumTwo(new int[]{9, 2, 2, 4, 6, 1, 5}, 8).size());
      assertEquals(3, CombinationSumTwo.combinationSumTwo(new int[]{1, 2, 3, 4, 5}, 7).size());
      assertEquals(0, CombinationSumTwo.combinationSumTwo(new int[]{3}, 5).size());
      assertEquals(4, CombinationSumTwo.combinationSumTwo(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).size());
      assertEquals(1, CombinationSumTwo.combinationSumTwo(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30).size());
   }
}