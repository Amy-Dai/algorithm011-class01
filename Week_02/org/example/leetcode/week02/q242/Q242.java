package org.example.leetcode.week02.q242;

import java.util.*;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (null == s && null != t || (null != s && null == t)) {
            return false;
        }
        if (null == s || null == t) {
            return true;
        }
        /*char[] sAray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sAray);
        Arrays.sort(tArray);
        return new String(sAray).equals(new String(tArray));*/

        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCounter = new HashMap<>();
        for (int i = 0, count = 0; i < s.length(); i++, count = 0) {
            charCounter.put(s.charAt(i), charCounter.getOrDefault(s.charAt(i), 0) + 1);
            charCounter.put(t.charAt(i), charCounter.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int count : charCounter.values()) {
            if (0 != count) {
                return false;
            }
        }
        return true;
    }
}
