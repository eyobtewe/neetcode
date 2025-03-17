package heap_n_priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
   public static int[][] kClosest(int[][] points, int k) {

      PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0]));

      for ( int i = 0; i < points.length; i++ ) {
         int x = points[i][0], y = points[i][1];
         int distance = x * x + y * y;
         maxHeap.offer(new int[]{distance, x, y});

         if ( maxHeap.size() > k ) maxHeap.poll();

      }

      int[][] answer = new int[k][2];

      for ( int i = 0; i < answer.length; i++ ) {
         int[] point = maxHeap.poll();
         answer[i][0] = point[1];
         answer[i][1] = point[2];
      }

      return answer;

   }

//   public static void main(String[] args) {
//      System.out.println(Arrays.deepToString(
//            kClosest(new int[][]{{0, 2}, {2, 0}, {2, 2}}, 2)));
//
//      System.out.println(Arrays.deepToString(
//            kClosest(new int[][]{{2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {1, 1}}, 2)));
//   }
}
