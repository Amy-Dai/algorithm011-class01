package org.example.leetcode.week03.q236;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q236solution2 {

    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private List<Integer> visited = new ArrayList<>();

    /**
     * 在一个不含相同整数的二叉树中查找特定节点p、q的最近公共祖先
     * 思路：
     * 1、利用深度遍历方法，基于哈希表存储每个节点的父亲；
     * 2、从p开始向根节点进行遍历，保存这个遍历路径；
     * 3、从q开始向根节点进行遍历，遍历期间，一旦发现在“p至根节点路径”中包含某个节点，则这个节点就是LCA（p、q的最近公共祖先）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }

        parentMap.put(root.val, null);
        dfs(root);

        TreeNode tmpFather = null;
        TreeNode tmp = p;
        while (null != tmp) {
            tmpFather = parentMap.get(tmp.val);
            visited.add(tmp.val);
            tmp = tmpFather;
        }

        tmp = q;
        while (null != tmp) {
            if (visited.contains(tmp.val)) {
                return tmp;
            }
            tmp = parentMap.get(tmp.val);
        }
        return null;
    }

    /**
     * 利用深度遍历方法记录每个节点的父亲
     * @param root
     */
    private void dfs(TreeNode root) {
        if (null != root.left) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (null != root.right) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
