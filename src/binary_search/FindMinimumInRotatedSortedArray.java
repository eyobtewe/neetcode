package binary_search;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class FindMinimumInRotatedSortedArray {
   public int findMin(int[] nums) {
      System.out.println(Arrays.toString(nums));
      if ( nums.length == 0 ) return -1;
      if ( nums.length == 1 ) return nums[0];

      int left = 0, right = nums.length - 1, mid = (left + right) / 2;

      while ( left < right ) {
         if ( left + 1 == right ) return Math.min(nums[left], nums[right]);
         mid = (left + right) / 2;

         if ( nums[mid] < nums[right] ) {
            right = mid;
         } else {
            left = mid;
         }
      }
      return nums[left];
   }

   @Test
   public void testFindMin() {

      assertEquals(1, findMin(new int[]{3, 4, 5, 6, 1, 2}));
      assertEquals(1, findMin(new int[]{5, 1, 2, 3, 4}));
      assertEquals(1, findMin(new int[]{2, 3, 1}));
      assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
      assertEquals(11, findMin(new int[]{11, 13, 15, 17}));
      assertEquals(1,findMin(new int[]{3,4,5,6,1,2}));
   }
}
