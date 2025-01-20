package binary_search;

import java.util.Arrays;

import tree.tree_node.TreeNode;

public class BinarySearch {
    private static int index = 0;

    public static void main(String[] args) {
        int[] numbers = { -1, 0, 2, 4, 6, 8 };
        System.out.println(
                "\nreturned" + search((numbers), 4));
    }

    public static int search(int[] nums, int target) {
        int mid = nums.length / 2;
        if (nums[mid] > target) {
            index += mid;
            return search(Arrays.copyOfRange(nums, 0, mid), target);
        } else if (nums[mid] < target) {
            index -= mid;
            return search(Arrays.copyOfRange(nums, mid + 1, nums.length), target);
        } else {

            System.out.printf("index ->%d,\t value->%d", mid, nums[mid]);
            return mid;

        }

    }

}
