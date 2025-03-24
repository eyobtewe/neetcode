package heap_n_priority_queue;

// Find Median From Data Stream
/*
The median is the middle value in an ordered integer list. If the size of the list is even,
there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
   PriorityQueue<Integer> maxHeap;
   PriorityQueue<Integer> minHeap;

   public MedianFinder() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
   }

   public void addNum(int num) {

      maxHeap.offer(num);
      if ( maxHeap.size() > minHeap.size() + 1 ||
            (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) ) {
         minHeap.offer(maxHeap.poll());
      }

      if ( minHeap.size() > maxHeap.size() + 1 ) {
         maxHeap.offer(minHeap.poll());
      }

   }

   public double findMedian() {


      if ( maxHeap.size() == minHeap.size() ) {
         return (double) (maxHeap.peek() + minHeap.peek()) / 2;
      } else if ( maxHeap.size() > minHeap.size() ) {
         return maxHeap.peek();
      } else {
         return minHeap.peek();
      }

   }
}
