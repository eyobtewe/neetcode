package tree;

import tree.tree_node.TreeNode;

public class SameBinaryTree {

   public static boolean isSameTree(TreeNode p, TreeNode q) {
      if ( p == null || q == null ) {
         return p == q;
      } else if ( p.val != q.val ) {
         return false;
      }

      boolean left = isSameTree(p.left, q.left);
      if ( !left ) {
         return false;
      }

      return isSameTree(p.right, q.right);
   }
}
