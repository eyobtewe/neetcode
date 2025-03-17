package heap_n_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
   public static int lastStoneWeight(int[] stones) {

      if ( stones.length == 0 ) return 0;
      else if ( stones.length == 1 ) return stones[0];

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

      for ( int i : stones ) maxHeap.add(i);

      int x, y;

      while ( maxHeap.size() > 1 ) {
         x = maxHeap.poll();
         y = maxHeap.poll();

         if ( x > y ) maxHeap.add(x - y);
      }

      return maxHeap.isEmpty() ? 0 : maxHeap.peek();

   }

//   public static void main(String[] args) {
//      System.out.println(lastStoneWeight(new int[]{2, 3, 6, 2, 4}));
//   }
}
