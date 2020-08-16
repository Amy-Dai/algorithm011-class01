package org.example.leetcode.week03.q105;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
 */
public class Q105Best {
    private int preOrderId;
    private int inOrderId;

    /**
     * 递归构造，考虑通过分割前序、中序遍历数组，在中序遍历数组中查找根节点需要o(n)的空间复杂度，引入遍历前序、中序数组的索引，当在中序数组中找到根节点，停止遍历中序数组
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuild(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode myBuild(int[] preorder, int[] inorder, int inordRootVal) {
        if (preOrderId >= preorder.length) {
            return null;
        }
        if (inorder[inOrderId] == inordRootVal) {
            inOrderId++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrderId++]);
        root.left = myBuild(preorder, inorder, root.val);
        root.right = myBuild(preorder, inorder, inordRootVal);
        return root;
    }
}
