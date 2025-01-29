package binary_search;

import java.util.Arrays;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 01, 02, 04, 8 },
                { 10, 11, 12, 13 },
                { 14, 15, 16, 17 },
                { 18, 19, 20, 21 },
                { 22, 23, 24, 25 },
                { 26, 27, 28, 29 }
        };
        int target = 11;

        searchMatrix(matrix, target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // int mid = matrix.length / 2;

        int[] firstColumn = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            firstColumn[i] = matrix[i][0];
        }

        System.out.println(Arrays.toString(firstColumn));

        int rowIndex = binarySearch(0, firstColumn.length - 1, firstColumn, target, true);
        System.out.println(rowIndex);
        if (rowIndex != -1) {
            int index = binarySearch(0, matrix[rowIndex].length - 1, matrix[rowIndex], target, false);
            System.out.println(index);
        } else {
            System.out.println("Doesn't exist");
            return false;
        }

        return true;

    }

    public static int binarySearch(int left, int right, int[] arr, int traget, boolean firstRound) {
        try {
            if (firstRound && right == (left + 1)) {
                return left;
            }
            if (left < right) {
                return -1;
            }

            int mid = left + (right - left) / 2;

            if (arr[mid] == traget) {
                return mid;
            }
            System.out.println(arr[mid]);

            return arr[mid] > traget ? binarySearch(left, mid, arr, traget, firstRound)
                    : binarySearch(mid, right, arr, traget, firstRound);

        } catch (Exception e) {
            return -1;
        }
    }
}
