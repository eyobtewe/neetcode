package backtracking;

import java.util.*;

public class CombinationSumTwo {

   public static void backtrack(int start, int[] candidates, int target, List<Integer> partials,
                                Set<List<Integer>> solutions) {

      if ( target == 0 ) {
         solutions.add(new ArrayList<>(partials));
         return;
      }

      for ( int i = start; i < candidates.length; i++ ) {
         if ( i > start && candidates[i] == candidates[i - 1] ) continue;
         if ( target < candidates[i] ) break;

         partials.add(candidates[i]);

         backtrack(i + 1, candidates, target - candidates[i], partials, solutions);

         partials.remove(partials.size() - 1);

      }

   }

   public static List<List<Integer>> combinationSumTwo(int[] candidates, int target) {
      Set<List<Integer>> solutions = new HashSet<>();

      Arrays.sort(candidates);

      backtrack(0, candidates, target, new ArrayList<>(), solutions);


      return solutions.stream().toList();
   }

//   [10, 1, 2, 7, 6, 1, 5] = 8
//   public static void main(String[] args) {
//      CombinationSumTwo.combinationSumTwo(new int[]{9, 2, 2, 4, 6, 1, 5}, 8);
//   }

}
