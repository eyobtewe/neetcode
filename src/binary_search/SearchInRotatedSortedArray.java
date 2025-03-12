package binary_search;

public class SearchInRotatedSortedArray {
   public int search(int[] nums, int target) {

      int left = 0, right = nums.length - 1, mid;

      while (left <= right) {

         mid = (left + right) / 2;

         if (nums[mid] == target)
            return mid;

         if (nums[left] <= nums[mid]) {
            if (target > nums[mid] || target < nums[left]) {
               left = mid + 1;
            } else
               right = mid - 1;
         } else {
            if (target < nums[mid] || target > nums[right]) {
               right = mid - 1;
            } else
               left = mid + 1;
         }

      }

      return -1;
   }

   // @Test
   // public void testSearch() {

   // assertEquals(4, search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
   // assertEquals(4, search(new int[] { 3, 4, 5, 6, 1, 2 }, 1));
   // assertEquals(-1, search(new int[] { 3, 5, 6, 0, 1, 2 }, 4));
   // assertEquals(-1, search(new int[] { 1 }, 0));
   // assertEquals(1, search(new int[] { 5, 1, 2, 3, 4 }, 1));
   // }
}
