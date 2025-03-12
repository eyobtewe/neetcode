package binary_search;

import org.junit.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class KokoEatingBananas {

   public static void main(String[] args) {
      int[] piles = new int[]{3, 6, 7, 11};
      int[] piles2 = new int[]{30, 11, 23, 4, 20};
      int[] piles3 = new int[]{3, 6, 7, 11};
      int[] piles4 = new int[]{805_306_368, 805_306_368, 805_306_368};

      System.out.println(minEatingSpeed(piles, 8)); //4

      System.out.println(minEatingSpeed(piles2, 5)); //30
      System.out.println(minEatingSpeed(piles2, 6)); //23
      System.out.println(minEatingSpeed(piles3, 18)); //2
      System.out.println(minEatingSpeed(piles4, 1_000_000_000)); //3 [8,8,8]->10

   }

   public static int minEatingSpeed(int[] piles, int h) {

      if ( piles.length > h ) return -1;

//      System.out.print(Arrays.toString(piles) + '\t' + h+"\t-> ");

      int right = Arrays.stream(piles).max().getAsInt();

      int left = 1;

      while (left < right) {
         int mid = left + (right - left) / 2;
         long hours = 0;

         for (int pile : piles) {
            hours += (long) Math.ceil((double) pile / (double) mid);
         }

         if (hours <= h) {
            right = mid;
         } else {
            left = mid + 1;
         }
      }

      return left;
   }

//   @Test
//   public void testMinEatingSpeed() {
//      int[] piles = new int[]{3, 6, 7, 11};
//      int[] piles2 = new int[]{30, 11, 23, 4, 20};
//      int[] piles3 = new int[]{3, 6, 7, 11};
//      int[] piles4 = new int[]{805_306_368, 805_306_368, 805_306_368};
//      int[] piles5 = new int[]{805, 805, 805};
//
//      assertEquals(4, minEatingSpeed(piles, 8));
//      assertEquals(30, minEatingSpeed(piles2, 5));
//      assertEquals(23, minEatingSpeed(piles2, 6));
//      assertEquals(2, minEatingSpeed(piles3, 18));
//      assertEquals(3, minEatingSpeed(piles4, 1_000_000_000));
//      assertEquals(3, minEatingSpeed(piles5, 999));
//   }
}
