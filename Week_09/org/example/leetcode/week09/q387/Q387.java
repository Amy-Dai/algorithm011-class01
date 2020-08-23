package org.example.leetcode.week09.q387;

public class Q387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int lastSameCharId = -1, firstSameCharId = -1;
        for (int i = 0; i < s.length(); i++) {
            lastSameCharId = s.lastIndexOf(s.charAt(i));
            firstSameCharId = s.indexOf(s.charAt(i));
            if (lastSameCharId == i && firstSameCharId == i) {
                return i;
            }
        }
        return -1;
    }
}
