package tree;

import tree.tree_node.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        this.diameter = Math.max(this.diameter, left + right);

        return Math.max(left, right) + 1;

    }

}
