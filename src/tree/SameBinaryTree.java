package tree;

import tree.tree_node.TreeNode;

public class SameBinaryTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        // System.out.printf("%d != %d\n", p.val, q.val);
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
