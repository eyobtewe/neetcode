package heap_n_priority_queue;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
   private final int kth;
   private final PriorityQueue<Integer> numbers;

   public KthLargestElementInStream(int k, int[] nums) {
      kth = k;
      numbers = new PriorityQueue<>();
      for ( int i : nums ) numbers.add(i);
   }

//   public static void main(String[] args) {
//      int k = 3;
//      int[] nums = {1, 2, 3, 3};
//      KthLargestElementInStream kthLargest = new KthLargestElementInStream(k, nums);
//
//      System.out.println((kthLargest.add(7)));
//      kthLargest.add(5);
//      kthLargest.add(9);
//      kthLargest.add(8);
//      kthLargest.add(4);
//      kthLargest.add(6);
//      kthLargest.add(2);
//   }

   public int add(int val) {
      numbers.add(val);
      while ( numbers.size() > kth ) numbers.poll();
      return numbers.peek();
   }

}
