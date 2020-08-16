package org.example.leetcode.week08.q191;

public class Q191Solution3 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }
}
