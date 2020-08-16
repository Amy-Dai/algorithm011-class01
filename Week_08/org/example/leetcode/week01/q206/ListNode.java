package org.example.leetcode.week01.q206;

public class ListNode {
    private int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public String print() {
        StringBuffer resultBuff = new StringBuffer();
        ListNode curNode = this;
        while (null != curNode) {
            resultBuff.append(curNode.val);
            curNode = curNode.next;
        }
        return resultBuff.toString();
    }
}
