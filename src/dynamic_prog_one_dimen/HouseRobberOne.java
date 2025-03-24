package dynamic_prog_one_dimen;

public class HouseRobberOne {

   public static int rob(int[] nums) {

      if ( nums.length  == 1 ) return nums[0];
      if ( nums.length  == 2 ) return Math.max(nums[0], nums[1]);

      int[] loot = new int[nums.length];
      loot[0] = nums[0];
      loot[1] = Math.max(nums[0], nums[1]);

      for ( int i = 2; i < nums.length; i++ ) {
         loot[i] = Math.max(loot[i - 1], loot[i - 2] + nums[i]);
      }

      return loot[loot.length - 1];
   }

//   public static void main(String[] args) {
//      System.out.println(rob(new int[]{1, 2, 3, 1}) + "\t 4");
//      System.out.println(rob(new int[]{2,7,9,3,1}) + "\t 12");
//   }

}
