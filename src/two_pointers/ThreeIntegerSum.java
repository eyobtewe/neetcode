package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeIntegerSum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(numbers));
    }

    public static List<List<Integer>> threeSum(int[] numbers) {

        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(numbers);

        if ( 3 > numbers.length ) {
            return sumList;
        }

        for ( int i = 0; i < numbers.length; i++ ) {

            if ( i > 0 && numbers[i] == numbers[i - 1] ) continue;

            int left = i + 1, right = numbers.length - 1;

            while ( left < right ) {

                if ( numbers[i] + numbers[left] + numbers[right] == 0 ) {
                    List<Integer> list = Arrays.asList(numbers[i], numbers[left], numbers[right]);
                    sumList.add(list);

                    while ( left < right && numbers[left] == numbers[left + 1] ) left++;
                    while ( left < right && numbers[right] == numbers[right - 1] ) right--;


                    left++;
                    right--;
                } else if ( numbers[i] + numbers[left] + numbers[right] > 0 ) {


                    right--;
                } else {
                    left++;
                }
            }

        }


        return sumList;
    }
}
