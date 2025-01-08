package linked_list;

// o(n) time | o(1) space
public class FindTheDuplicateNumber {

   private static int getDuplicate(int[] nums) {
      // Phase 1: Detect the cycle using Floyd's Tortoise and Hare
      int slow = nums[0];
      int fast = nums[0];

      do {
         slow = nums[slow];          // Move slow pointer one step
         fast = nums[nums[fast]];    // Move fast pointer two steps
      } while ( slow != fast );

      // Phase 2: Find the start of the cycle (duplicate number)
      int slow2 = nums[0];           // Start a new pointer at the beginning
      while ( slow != slow2 ) {
         slow = nums[slow];         // Move both pointers one step at a time
         slow2 = nums[slow2];
      }
      return slow;
   }

   public int findDuplicate(int[] nums) {
      // Edge Case 1: Array has fewer than 2 elements
      if ( nums == null || nums.length < 2 ) return -1;

      // Edge Case 2: Check if all values are within bounds [1, n]
      for ( int num : nums ) {
         if ( num < 1 || num >= nums.length ) {
            throw new IllegalArgumentException("Array values must be within the range [1, n]");
         }
      }

      return getDuplicate(nums);
   }
}
