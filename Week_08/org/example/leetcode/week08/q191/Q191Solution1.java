package org.example.leetcode.week08.q191;

public class Q191Solution1 {
    public int hammingWeight(int n) {
        int result = 0;
        String byteString = Integer.toBinaryString(n);
        for (int i = 0; i < byteString.length(); i++) {
            if (byteString.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
