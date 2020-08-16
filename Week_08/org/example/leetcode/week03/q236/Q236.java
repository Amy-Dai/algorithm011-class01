package org.example.leetcode.week03.q236;

public class Q236 {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ( (lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            result = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
