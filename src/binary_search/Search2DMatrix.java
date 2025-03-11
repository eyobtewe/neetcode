package binary_search;

public class Search2DMatrix {
   public static void main(String[] args) {

      int[][] matrix = new int[][]{
            {1, 2, 4, 8},
            {10, 11, 12, 13},
            {14, 15, 16, 17},
            {18, 19, 20, 21},
            {22, 23, 24, 25},
            {26, 27, 28, 29}
      };

      int target = 2;

      System.out.println(searchMatrix(matrix, target));
   }

   public static boolean searchMatrix(int[][] matrix, int target) {
      int[] firstColumn = new int[matrix.length];

      for ( int i = 0; i < matrix.length; i++ ) {
         firstColumn[i] = matrix[i][0];
      }

      int row = binarySearch(firstColumn, target, 0, matrix.length - 1, true);
      if ( row >= 0 ) return true;
      else if ( row < -9 ) {
         int i = -(row + 10);
         System.out.println(i);
         int index = binarySearch(matrix[i], target, 0, matrix[i].length - 1, false);
         return index > -1;
      }

//      System.out.println("row: " + row);

      return false;
   }

   public static int binarySearch(int[] arr, int target, int left, int right, boolean column) {

      if ( left > right ) {

//         System.out.printf("(%d,%d)\n", left, right);

         if ( column ) return -left - 10 + 1;

//         if ( left <= 0 ) {
//            System.out.println("is less than the array");
//         } else if ( right >= arr.length - 1 ) {
//            System.out.println("is bigger than the array");
//         }
         return -1;
      }

      int mid = (left + right) / 2;

      if ( target > arr[mid] ) {
         return binarySearch(arr, target, mid + 1, right, column);
      } else if ( target < arr[mid] ) {
         return binarySearch(arr, target, left, mid - 1, column);
      } else {
         return mid;
      }

   }

}
