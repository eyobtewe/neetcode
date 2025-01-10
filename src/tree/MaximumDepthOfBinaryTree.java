package tree;

import tree.tree_node.TreeNode;

public class MaximumDepthOfBinaryTree {

   public static int maxDepth(TreeNode root) {

      if (root == null)
         return 0;

      int left = maxDepth(root.left) + 1;
      int right = maxDepth(root.right) + 1;

      return Math.max(left, right);
   }

}
