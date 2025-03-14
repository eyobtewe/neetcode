package tree;

import tree.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
   static List<List<Integer>> d;

   public static void treeTraversal(TreeNode treeNode, int level) {
      if ( treeNode == null ) return;


      List<Integer> temp = new ArrayList<>();

      if ( level < d.size() && d.get(level) != null ) {
         temp = d.get(level);
         temp.add(treeNode.val);
         d.set(level, temp);
      } else {
         temp.add(treeNode.val);
         d.add(temp);
      }

      if ( treeNode.left != null ) treeTraversal(treeNode.left, level + 1);
      if ( treeNode.right != null ) treeTraversal(treeNode.right, level + 1);

   }

   public static List<List<Integer>> levelOrder(TreeNode root) {
      d = new ArrayList<>();
      treeTraversal(root, 0);
      return d;
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
      root2.right.right.right = new TreeNode(1);
      root2.right.right.left = new TreeNode(3);

      // System.out.println(" Tree 1 ");
      // displayTree(root);
      System.out.println(" Tree 2 ");
      TreeNode.displayTree(root2);
      levelOrder(root2);
      System.out.println(d);
   }
}
