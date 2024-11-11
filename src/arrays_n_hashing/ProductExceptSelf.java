package arrays_n_hashing;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        for ( int i = 0; i < output.length; i++ ) {
            output[i]=1;
            for ( int j = 0; j < output.length; j++ ) {
                if ( j != i ) {
                    output[i] *= nums[j];
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 6};
        int[] nums2 = {-1, 0, 1, 2, 3};

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));

    }
}
