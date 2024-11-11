package arrays_n_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 21, 21, 39, 39, 39, 44, 44, 44};
        topKFrequent(nums, 2);
        int[] nums2 = new int[]{5, 3, 1, 1, 1, 3, 73, 1};
        topKFrequent(nums2, 2);

    }

    public static int[] topKFrequent(int[] array, int k) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int largestFrequency = 0;

        for ( int item : array ) {
            int temp = frequencyMap.getOrDefault(item, 0) + 1;
            frequencyMap.put(item, temp);
            largestFrequency = Math.max(largestFrequency, temp);
        }

        List<Integer>[] answer = new ArrayList[largestFrequency + 1];

        frequencyMap.forEach((key, value) -> {
            List<Integer> temp = answer[value];
            if ( temp == null ) {
                temp = new ArrayList<>();
            }
            temp.add(key);
            answer[value] = temp;
        });

        int[] finalAnswer = new int[k];
        System.out.println(Arrays.toString(answer));

        while ( k != 0 ) {
            if ( answer[largestFrequency] != null ) {
                for ( Integer item : answer[largestFrequency] ) {
                    k--;
                    finalAnswer[k] = item;
                }
            }
            largestFrequency--;
        }

        System.out.println(Arrays.toString(finalAnswer));
        return finalAnswer;
    }


}
