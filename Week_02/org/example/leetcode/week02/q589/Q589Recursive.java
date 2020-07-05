package org.example.leetcode.week02.q589;

import java.util.ArrayList;
import java.util.List;

public class Q589Recursive {
    public List<Integer> preorder(Node root) {
        List<Integer> path = new ArrayList<>();
        preorderRecusion(root, path);
        return path;
    }

    private void preorderRecusion(Node root, List<Integer> path) {
        if (null == root) {
            return;
        }
        path.add(root.val);
        if (null != root.children) {
            for (Node tmp : root.children) {
                preorderRecusion(tmp, path);
            }
        }
    }
}
