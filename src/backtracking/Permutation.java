package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
   public static List<List<Integer>> permute(int[] nums) {

      List<List<Integer>> solutions = new ArrayList<>();

      backtrack(nums, solutions, new ArrayList<>(), new int[nums.length]);
      solutions.forEach(System.out::println);
      return solutions;
   }

   public static void backtrack(int[] nums, List<List<Integer>> solutions, List<Integer> partial, int[] used) {

      if ( partial.size() == nums.length ) {
         solutions.add(new ArrayList<>(partial));
         return;
      }

      for ( int i = 0; i < nums.length; i++ ) {

         if ( used[i] == 1 ) continue;

         partial.add(nums[i]);
         used[i] = 1;

         backtrack(nums, solutions, partial, used);

         partial.remove(partial.size()-1);
         used[i] = 0;

      }

   }

   public static void main(String[] args) {
      permute(new int[]{1, 2, 3});
   }

}
