package tree;

import org.junit.Test;
import tree.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class ValidBinarySearchTree {

   public static boolean isValidBST(TreeNode root) {
      List<Integer> numbers = new ArrayList<>();
      inorderTraverse(root, numbers);
      for ( int i = 1; i < numbers.size(); i++ ) {
         if ( numbers.get(i - 1) >= numbers.get(i) ) return false;
      }
      return true;
   }

   public static void inorderTraverse(TreeNode root, List<Integer> numbers) {
      if ( root == null ) return;

      inorderTraverse(root.left, numbers);
      numbers.add(root.val);
      inorderTraverse(root.right, numbers);
   }

//         [2,1,3]
//         [5,1,4,null,null,3,6]
//         [0]
//         [0,-1]
//
//   @Test
//   public void testIsValidBST() {
//
//      TreeNode treeNode = new TreeNode(new Object[]{2, 1, 3});
//      TreeNode treeNode2 = new TreeNode(new Object[]{5, 1, 4, null, null, 3, 6});
//      TreeNode treeNode3 = new TreeNode(new Object[]{0});
//      TreeNode treeNode4 = new TreeNode(new Object[]{0, -1});
//      TreeNode treeNode5 = new TreeNode(new Object[]{5, 4, 6, null, null, 3, 7});
//
////      TreeNode.displayTree(treeNode5);
//      assertTrue(isValidBST(treeNode));
//      assertFalse(isValidBST(treeNode2));
//      assertTrue(isValidBST(treeNode3));
//      assertTrue(isValidBST(treeNode4));
//      assertFalse(isValidBST(treeNode5));
//   }
}
