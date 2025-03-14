package binary_search;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
   public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] merged = new int[nums1.length+nums2.length];

//      merged = nums1;

      System.out.println(Arrays.toString(nums1));
      System.out.println(Arrays.toString(nums2));
      System.out.println(Arrays.toString(merged));
      System.out.printf("%d, %d ,%d",nums1.length,nums2.length,merged.length);

      return 0.0;
   }

   public static void main(String[] args) {
      findMedianSortedArrays(new int[]{1,2,3},new int[]{6,7,8});
//      findMedianSortedArrays(new int[]{1,2,3},new int[]{6,7,8});
   }
}
