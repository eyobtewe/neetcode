package tree;

import tree.tree_node.TreeNode;

public class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        isBalanced = isBalanced && Math.abs(left - right) <= 1;

        return Math.max(left, right) + 1;
    }
}
