package org.example.leetcode.week01.q206;

public class Q206Iteration {
    public ListNode reverseList(ListNode head) {
        ListNode last = null, curNode = head, tmp = null;
        while (null != curNode) {
            tmp = curNode.next;
            curNode.next = last;
            last = curNode;
            curNode = tmp;
        }
        return last;
    }
}
