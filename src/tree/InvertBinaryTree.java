package tree;

import tree.tree_node.TreeNode;

public class InvertBinaryTree {

   public static TreeNode invertTree(TreeNode root) {

      if ( root == null ) return null;

      TreeNode temp = root.left;
      root.left = invertTree(root.right);
      root.right = invertTree(temp);

      return root;
   }

}