package arrays_n_hashing;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};

        System.out.println(
                Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] array, int k) {

        Map<Integer, Integer> frequncyMap = new HashMap<>();

        for ( int item : array ) {
            int temp = 0;

            if ( frequncyMap.containsKey(item) ) {
                temp =   frequncyMap.get(item);
                temp++;
                frequncyMap.put(item, temp);
            } else {
                frequncyMap.put(item, 1);
            }
        }

        List<Integer> answer  = new ArrayList<>();
        frequncyMap.forEach((key,value)->{
            if ( value>=k ){
                answer.add(key);
            }
        });
//
//        System.out.println(answer);
//
//        int i=0;
        int[] freq = new int[k];
//        for ( Integer in:answer ){
//            freq[i++]=in;
//        }

        return freq;
    }
}
