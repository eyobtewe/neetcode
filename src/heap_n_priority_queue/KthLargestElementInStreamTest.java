package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestElementInStreamTest {

   @Test
   void add() {
      int k = 3;
      int[] nums = {1, 2, 3, 3};
      KthLargestElementInStream kthLargest = new KthLargestElementInStream(k, nums);


//      1,2,3,3
      assertEquals(3, kthLargest.add(3)); // Output: 3
//      1,2,3,3,3
      assertEquals(3, kthLargest.add(5)); // Output: 3
//      1,2,3,3,3,5
      assertEquals(3, kthLargest.add(6)); // Output: 3
//      1,2,3,3,3,5,6
      assertEquals(5, kthLargest.add(7)); // Output: 5
//      1,2,3,3,3,5,6,7
      assertEquals(6, kthLargest.add(8)); // Output: 6
//      1,2,3,3,3,5,6,7,8
      assertEquals(6, kthLargest.add(2)); // Output: 6
//      1,2,2,3,3,3,5,6,7,8
      assertEquals(7, kthLargest.add(9)); // Output: 6
//      1,2,2,3,3,3,5,6,7,8,9
   }
}