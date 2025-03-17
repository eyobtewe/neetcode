package heap_n_priority_queue;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
   public static int findKthLargest(int[] nums, int k) {
      if ( k > nums.length ) return -1;
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

      for ( int i : nums ) {
         maxHeap.add(i);
         if ( maxHeap.size() > k ) maxHeap.poll();
      }

      return maxHeap.peek();

   }

}
