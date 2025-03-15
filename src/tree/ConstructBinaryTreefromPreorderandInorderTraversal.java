package tree;

import tree.tree_node.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

   private static int preOrderIndex;
   private static HashMap<Integer, Integer> inorderIndexMap;

   public static TreeNode buildTree(int[] preorder, int[] inorder) {
      preOrderIndex = 0;
      inorderIndexMap = new HashMap<>();

      // Store inorder indices in a hashmap for quick lookup
      for ( int i = 0; i < inorder.length; i++ ) {
         inorderIndexMap.put(inorder[i], i);
      }

      return buildActualTree(preorder, 0, inorder.length - 1);
   }

   public static TreeNode buildActualTree(int[] preorder, int left, int right) {
      if ( left > right ) return null;
      // Pick the current root from preorder
      TreeNode root = new TreeNode(preorder[preOrderIndex++]);

      // Get the root index from inorder map
      int inorderIndex = inorderIndexMap.get(root.val);

      // Recursively build left and right subtrees
      root.left = buildActualTree(preorder, left, inorderIndex - 1);
      root.right = buildActualTree(preorder, inorderIndex + 1, right);

      return root;

   }

   public static void main(String[] args) {
      TreeNode tree = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
      TreeNode.displayTree(tree);

   }

}
