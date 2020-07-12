package org.example.leetcode.week03.q105;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    /**
     * 根据前序遍历、中序遍历，判断根节点索引，进而识别根节点的左子树、右子树；如此递归方式构造左子树、右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length != inorder.length || 0 == preorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 在中序遍历数组中查找根节点索引pId
        int pId = inOrderMap.containsKey(preorder[preLeft])? inOrderMap.get(preorder[preLeft]) : -1;
        if (-1 == pId) {
            return null;
        }

        // 在前序遍历数组中查找左子树最后一个节点索引preLeftLastId
        int preLeftLastId = pId - inLeft + preLeft;
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeftLastId, inLeft, pId - 1);
        root.right = myBuildTree(preorder, inorder, preLeftLastId + 1, preRight, pId + 1, inRight);
        return root;
    }
}
