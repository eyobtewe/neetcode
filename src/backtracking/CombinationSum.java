package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
   static Set<List<Integer>> solutions;

   public static List<List<Integer>> combinationSum(int[] nums, int target) {
      solutions = new HashSet<>();
      backtrack(nums, 0, target, new ArrayList<>());
      System.out.println(solutions);
      return solutions.stream().toList();
   }

   public static void backtrack(int[] nums, int start, int target, List<Integer> partialSolutions) {
      if ( 0 == target ) {
         solutions.add(new ArrayList<>(partialSolutions));
         return;
      }

      for ( int i = start; i < nums.length; i++ ) {
         int num = nums[i];
         if ( target < num ) continue;

         partialSolutions.add(num);

         backtrack(nums, i, target - num, partialSolutions);

         partialSolutions.remove(partialSolutions.size()-1);

      }
   }

}
