package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = { -1, 0, 2, 4, 6, 8 };
        System.out.println(
                "\nreturned=> " + search((numbers), 13));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        try {

            if (left > right) {
                return -1;
            }

            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            return nums[middle] > target
                    ? binarySearch(nums, target, left, middle - 1)
                    : binarySearch(nums, target, middle + 1, right);
        } catch (Exception e) {
            return -1;
        }
    }
}