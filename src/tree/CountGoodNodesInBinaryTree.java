package tree;

import tree.tree_node.TreeNode;

public class CountGoodNodesInBinaryTree {
   private static int counter;

   public static int goodNodeFinder(TreeNode root, int max) {

      if ( root == null ) return counter;

      if ( root.right != null ) {
         if ( max <= root.right.val ) counter++;
         goodNodeFinder(root.right, Math.max(max,root.right.val));
      }
      if ( root.left != null ) {
         if ( max <= root.left.val ) counter++;
         goodNodeFinder(root.left, Math.max(max,root.left.val));
      }
      return counter;
   }

   public static int goodNodes(TreeNode root) {
      counter = 1;
      return root != null ? goodNodeFinder(root, root.val) : 0;
   }

   public static void main(String[] args) {
      TreeNode root2 = new TreeNode(4);
      root2.left = new TreeNode(2);
      root2.right = new TreeNode(7);
      root2.left.left = new TreeNode(1);
      root2.left.right = new TreeNode(3);
      root2.right.left = new TreeNode(6);
      root2.right.right = new TreeNode(7);
      root2.right.right.right = new TreeNode(1);
      root2.right.right.left = new TreeNode(3);

      // System.out.println(" Tree 1 ");
      // displayTree(root);
      System.out.println(" Tree 2 ");
      TreeNode.displayTree(root2);
      System.out.println(goodNodes(root2));
   }
}
