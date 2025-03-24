package dynamic_prog_one_dimen;

public class ClimbStairs {
   public int climbStairs(int n) {
      if ( n < 4 ) return n;

      int i1 = 1, i2 = 2;

      for ( int i = 3; i <= n; i++ ) {
         int temp = i1 + i2;
         i1 = i2;
         i2 = temp;
      }
      return i2;
   }
}
