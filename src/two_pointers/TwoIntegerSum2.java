package two_pointers;

import java.util.Arrays;

public class TwoIntegerSum2 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 7)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        Arrays.sort(numbers);

        int left = 0, right = numbers.length - 1;

        while ( left < right ) {
            if ( numbers[left] + numbers[right] == target ) {
                return new int[]{left + 1, right + 1};
            } else if ( numbers[left] + numbers[right] > target ) {
                right--;
            } else {
                left++;
            }

        }


        return new int[]{};
    }
}
