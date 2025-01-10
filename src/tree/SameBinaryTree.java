package tree;

import tree.tree_node.TreeNode;

public class SameBinaryTree {
    private boolean isSameTree = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return isSameTree;
    }

    public boolean traverse(TreeNode p,TreeNode q) {
        if (!isSameTree) {
            return isSameTree;
        }

        if (p.val==q.val) {
            
        }

        boolean left = traverse(p.left,q.left);
        boolean right = traverse(q.right,q.right);



        return left==right;
    }
}
