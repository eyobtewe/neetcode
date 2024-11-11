package arrays_n_hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        int length = 0;

        for ( int num : nums ) {
            numbers.add(num);
        }

        for ( int num : nums ) {
            if ( !numbers.contains(num - 1) ) {
                int counter = 0;
                int temp = countSequence(num, counter,numbers);
                length = Math.max(length, temp);
            }
        }

        return length;
    }

    public static int countSequence(int num, int counter,HashSet<Integer> numbers) {
        if ( numbers.contains(num) ) {
            return countSequence(num + 1, counter + 1,numbers);
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 20, 4, 10, 3, 4, 5};
        int[] numbers2 = {0, 3, 2, 5, 4, 6, 1, 1};
        int[] numbers3 = {0, 3, 2, 5, 4, 6, 1, 1, 9, 8, 7};

        System.out.println("->" + longestConsecutive(numbers));
        System.out.println("->" + longestConsecutive(numbers2));
        System.out.println("->" + longestConsecutive(numbers3));


    }
}
