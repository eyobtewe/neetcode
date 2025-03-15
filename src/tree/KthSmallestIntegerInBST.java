package tree;

import tree.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestIntegerInBST {

   public static void inOrderTraverse(TreeNode treeNode, List<Integer> numbers, int k) {
      if ( treeNode == null ) return;

      inOrderTraverse(treeNode.left, numbers, k);
      numbers.add(treeNode.val);
      if ( numbers.size()==k ) return;
      inOrderTraverse(treeNode.right, numbers, k);

   }

   public int kthSmallest(TreeNode root, int k) {
      List<Integer> nums = new ArrayList<>();
      inOrderTraverse(root,nums,k);
      return nums.getLast();

   }
}
