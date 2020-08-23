package org.example.leetcode.week09.q541;

public class Q541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return null;
        }
        char[] words = s.toCharArray();
        int start = -1, end = -1;
        for (int i = 0; i < s.length(); i += 2 * k) {
            end = Math.min(i + k, s.length()) - 1;
            start = i;
            while (start < end) {
                char tmpChar = words[start];
                words[start++] = words[end];
                words[end--] = tmpChar;
            }
        }
        return new String(words);
    }
}
