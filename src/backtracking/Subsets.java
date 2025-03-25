package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
   public static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> totalAnswer = new ArrayList<>();

      backtrack(totalAnswer, new ArrayList<>(), nums, 0);

      return totalAnswer;
   }

   public static void backtrack(List<List<Integer>> totalAnswer, List<Integer> temp, int[] nums, int start) {

      totalAnswer.add(new ArrayList<>(temp));

      for ( int i = start; i < nums.length; i++ ) {

         temp.add(nums[i]);

         backtrack(totalAnswer, temp, nums, i + 1);

         temp.remove(temp.size() - 1);

      }

   }

//   public static void main(String[] args) {
//      System.out.println(subsets(new int[]{1, 2, 3}));
//   }
}
