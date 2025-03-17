package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestElementInArrayTest {

   @Test
   void findKthLargest() {
      assertEquals(4, KthLargestElementInArray.findKthLargest(new int[]{2, 3, 1, 5, 4}, 2));
      assertEquals(4, KthLargestElementInArray.findKthLargest(new int[]{2, 3, 1, 1, 5, 5, 4}, 3));
      assertEquals(5, KthLargestElementInArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
      assertEquals(4, KthLargestElementInArray.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
   }
}