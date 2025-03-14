package tree;

import tree.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
   static List<Integer> nodesList;

   public static void treeTraversal(TreeNode treeNode, int level) {
      if ( treeNode == null ) return;

      if ( level < nodesList.size() && nodesList.get(level) != null ) {
         nodesList.set(level, treeNode.val);
      } else {
         nodesList.add(treeNode.val);
      }

      if ( treeNode.left != null ) treeTraversal(treeNode.left, level + 1);
      if ( treeNode.right != null ) treeTraversal(treeNode.right, level + 1);

   }

   public static List<Integer> rightSideView(TreeNode root) {
      nodesList = new ArrayList<>();
      treeTraversal(root, 0);

      return nodesList;
   }

   public static void main(String[] args) {
      // Tree 2
      TreeNode root2 = new TreeNode(4);
      root2.left = new TreeNode(2);
      root2.right = new TreeNode(7);
      root2.left.left = new TreeNode(1);
      root2.left.right = new TreeNode(3);
      root2.right.left = new TreeNode(6);
      root2.right.right = new TreeNode(7);
      root2.left.left.left = new TreeNode(1);
      root2.left.left.left.left = new TreeNode(3);

      System.out.println(" Tree 2 ");
      TreeNode.displayTree(root2);

      System.out.println(rightSideView(root2));
   }
}
