package tree.tree_node;

import tree.MaximumDepthOfBinaryTree;

// * Definition for a binary tree node.
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;

   public TreeNode() {}

   public TreeNode(int val) {this.val = val;}

   public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
   }

   public static void main(String[] args) {
      // Create a sample binary tree
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(9);

      System.out.println("Original Tree (Inorder Traversal):");
      displayTree(root);

      // Invert the tree
//      InvertBinaryTree.invertTree(root);
//
//      System.out.println("\nInverted Tree (Inorder Traversal):");
//      displayTree(root);

      System.out.printf("\nMaximum depth is (%d):",
            MaximumDepthOfBinaryTree.maxDepth(root));

   }

   // Helper function to display the tree with arrows
   private static void displayTree(TreeNode root) {
      displayTreeWithArrows(root, "", true);
   }

   private static void displayTreeWithArrows(TreeNode node, String prefix, boolean isRight) {
      if ( node != null ) {
         // Print the current node
         System.out.println(prefix + (isRight ? "└── " : "├── ") + node.val);

         // Recurse for the left and right children
         displayTreeWithArrows(node.left, prefix + (isRight ? "    " : "│   "), false);
         displayTreeWithArrows(node.right, prefix + (isRight ? "    " : "│   "), true);
      }
   }

}