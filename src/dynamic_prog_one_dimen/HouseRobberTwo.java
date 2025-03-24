package dynamic_prog_one_dimen;

import java.util.Arrays;

public class HouseRobberTwo {

   public static int rob(int[] nums) {
      if ( nums.length == 1 ) return nums[0];
      if ( nums.length == 2 ) return Math.max(nums[0], nums[1]);

      return Math.max(nums[0], Math.max(
                  helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                  helper(Arrays.copyOfRange(nums, 1, nums.length ))
            ));
   }

   public static int helper(int[] n) {
      int a = 0, b = 0;

      for ( int i : n ) {
         int temp = Math.max(b, a + i);
         a = b;
         b = temp;
      }
      return b;
   }

   public static void main(String[] args) {
      System.out.println(rob(new int[]{3, 4, 3}) + "\t 4");
      System.out.println(rob(new int[]{3, 5}) + "\t 5");
      System.out.println(rob(new int[]{2, 9, 8, 3, 6}) + "\t 15");
      System.out.println(rob(new int[]{2}) + "\t 2");
   }
}
