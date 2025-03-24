package dynamic_prog_one_dimen;

public class MinCostClimbingStairs {
   public static int minCostClimbingStairs(int[] cost) {

      for ( int i = cost.length - 3; i >= 0; i-- ) {
         cost[i] += Math.min(cost[i + 1], cost[i + 2]);
      }

      return Math.min(cost[0], cost[1]);

   }

//   public static int minCost(int[] c, int size) {
//      if ( size <= 2 ) return 0;
//      return
//            Math.min(
//                  minCost(c, size - 1) + c[size - 1],
//                  minCost(c, size - 2) + c[size - 2]
//            );
//   }

   public static void main(String[] args) {
      System.out.println(minCostClimbingStairs(new int[]{1, 2, 3}) + "\t2");
      System.out.println(minCostClimbingStairs(new int[]{1, 2, 1, 2, 1, 1, 1}) + "\t4");
   }

}
