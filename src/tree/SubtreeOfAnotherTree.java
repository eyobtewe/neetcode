package tree;

import tree.tree_node.TreeNode;

public class SubtreeOfAnotherTree {

   public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (subRoot == null) {
         return true;
      } else if (root == null) {
         return false;
      } else if (isSameTree(root, subRoot)) {
         return true;
      }

      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
   }

   public static boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null || q == null) {
         return p == q;
      }

      return p.val == q.val
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
   }
}

/*
 * public boolean isSubtree(TreeNode s, TreeNode t) {
 * if (t == null) return true; // Null tree is always a subtree
 * if (s == null) return false; // Main tree is empty, cannot have any subtrees
 * if (areIdentical(s, t)) return true; // Check if trees are identical
 * // Check left and right subtrees of S
 * return isSubtree(s.left, t) || isSubtree(s.right, t);
 * }
 * 
 * // Helper function to check if two trees are identical
 * private boolean areIdentical(TreeNode s, TreeNode t) {
 * if (s == null && t == null) return true; // Both are null
 * if (s == null || t == null) return false; // One is null, the other is not
 * // Compare the current node and recursively check left and right children
 * return (s.val == t.val) &&
 * areIdentical(s.left, t.left) &&
 * areIdentical(s.right, t.right);
 * }
 */