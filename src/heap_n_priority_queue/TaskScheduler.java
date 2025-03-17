package heap_n_priority_queue;

import java.util.Arrays;

record Pair(char key, int count) {
}

public class TaskScheduler {

   public static int leastInterval(char[] tasks, int n) {

      if ( tasks.length < 2 ) return tasks.length;

      int[] count = new int[26];

      for ( char c : tasks ) count[c - 'A']++;

      Arrays.sort(count);


      int max = 0;

      for ( int i = 25; i >= 0; i-- ) {
         if ( count[25] == count[i] ) max++;
         else break;
      }

      System.out.println(max);
      int minTime = (n + 1) * (count[25] - 1) + max;
      return Math.max(minTime, tasks.length);
   }

   public static void main(String[] args) {
      leastInterval(new char[]{'A', 'A', 'B', 'A', 'B', 'C', 'D', 'E'}, 3);
   }

}
