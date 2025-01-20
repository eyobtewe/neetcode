package tree;

import tree.tree_node.TreeNode;

public class LowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        if (p == null)
            return lowestCommonAncestor(root, q, q);
        if (q == null)
            return lowestCommonAncestor(root, p, p);

        // If the current root matches either p or q, it is the LCA.
        if (root.val == p.val || root.val == q.val)
            return root;

        // If p and q are on different sides of the root, the root is the LCA.
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }

        // If both p and q are greater than the root, recurse into the right subtree.
        if (p.val > root.val && q.val > root.val) {
            return (root.right == null) ? null : lowestCommonAncestor(root.right, p, q);
        }

        // Otherwise, both p and q must be smaller than the root, recurse into the left
        // subtree.
        return root.left == null ? null : lowestCommonAncestor(root.left, p, q);

    }
}
