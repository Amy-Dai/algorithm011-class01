package org.example.leetcode.q206;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode curNode, ListNode preNode) {
        if (null == curNode) {
            return preNode;
        }
        ListNode next = curNode.next;
        curNode.next = preNode;
        return reverse(next, curNode);
    }
}
