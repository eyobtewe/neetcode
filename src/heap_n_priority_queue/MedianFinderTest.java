package heap_n_priority_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

   private MedianFinder medianFinder;

   @BeforeEach
   void setUp() {
      medianFinder = new MedianFinder();
   }

   @Test
   void testFindMedianAfterAddingOneNumber() {
      medianFinder.addNum(1);
      assertEquals(1.0, medianFinder.findMedian(), "Median should be 1.0 after adding 1");
   }

   @Test
   void testFindMedianAfterAddingTwoNumbers() {
      medianFinder.addNum(1);
      medianFinder.addNum(2);
      assertEquals(1.5, medianFinder.findMedian(), "Median should be 1.5 after adding 1 and 2");
   }

   @Test
   void testFindMedianAfterAddingThreeNumbers() {
      medianFinder.addNum(1);
      medianFinder.addNum(2);
      medianFinder.addNum(3);
      assertEquals(2.0, medianFinder.findMedian(), "Median should be 2.0 after adding 1, 2, and 3");
   }

   @Test
   void testFindMedianAfterAddingEvenNumberOfElements() {
      medianFinder.addNum(1);
      medianFinder.addNum(3);
      medianFinder.addNum(2);
      medianFinder.addNum(4);
      assertEquals(2.5, medianFinder.findMedian(), "Median should be 2.5 after adding 1, 2, 3, and 4");
   }

   @Test
   void testFindMedianWithNegativeNumbers() {
      medianFinder.addNum(-1);
      medianFinder.addNum(2);
      medianFinder.addNum(-3);
      medianFinder.addNum(4);
      medianFinder.addNum(0);
      assertEquals(0.0, medianFinder.findMedian(), "Median should be 0.0 after adding -1, 2, -3, 4, and 0");
   }

   @Test
   void testAddNumPerformance() {
      MedianFinder medianFinder = new MedianFinder();

      long startTime = System.nanoTime();

      // Add 1 million numbers to test performance
      for ( int i = 0; i < 1_000_000; i++ ) {
         medianFinder.addNum(i);
      }

      long endTime = System.nanoTime();
      long duration = (endTime - startTime)/1000_000;

      System.out.println("Time taken to add 1 million numbers: " + duration + " ms");

      // Optional: We can also check the median to ensure it's still functioning correctly
      assertEquals(499_999.5, medianFinder.findMedian(), "Median should be 499_999.5 after adding 1 million numbers");
   }

   @Test
   void testFindMedianPerformance() {
      MedianFinder medianFinder = new MedianFinder();

      // Add numbers first
      for ( int i = 0; i < 1_000_000; i++ ) {
         medianFinder.addNum(i);
      }

      long startTime = System.nanoTime();

      // Test the performance of finding the median
      double median = medianFinder.findMedian();

      long endTime = System.nanoTime();
      long duration = (endTime - startTime)/100_000;

      System.out.println("Time taken to find the median after adding 1 million numbers: " + duration + " ms");

      // Optional: Check if the median is correct
      assertEquals(499_999.5, median, "Median should be 499_999.5 after adding 1 million numbers");
   }
}
