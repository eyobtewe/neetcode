package tree;

import tree.tree_node.TreeNode;

public class SubtreeOfAnotherTree {
    public static boolean isSubtree = false;

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (isSubtree) {
            return true;
        } else {
            isSubtree = isSameTree(root, subRoot);
        }
        if (isSubtree)
            return isSubtree;

        boolean left = isSameTree(root.left, subRoot);
        if (left)
            return true;

        boolean right = isSameTree(root.right, subRoot);

        return left || right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
