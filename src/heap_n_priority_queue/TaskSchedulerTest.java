package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskSchedulerTest {

   @Test
   void leastInterval() {
      assertEquals(8, TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
      assertEquals(10, TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
      assertEquals(6, TaskScheduler.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B',}, 1));
      assertEquals(5, TaskScheduler.leastInterval(new char[]{'X', 'X', 'Y', 'Y'}, 2));
      assertEquals(9, TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 3));
   }
}