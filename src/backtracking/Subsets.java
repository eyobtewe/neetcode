package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
   public static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> sets = new ArrayList<>((int) Math.pow(2, nums.length));

//      for ( int i = 0; i <= nums.length; i++ ) {

      setGenerator(sets, nums, 0);

      return sets;
   }

   public static void setGenerator(List<List<Integer>> sets, int[] numbers, int i) {
      List<Integer> set = new ArrayList<>();

      if ( i >= numbers.length ) {
         sets.add(set);
         return;
      }

      set.add(numbers[i]);
      setGenerator(sets, numbers, i + 1);

      set.removeLast();
      setGenerator(sets, numbers, i + 1);

//      sets.add(set);
   }

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }
}
