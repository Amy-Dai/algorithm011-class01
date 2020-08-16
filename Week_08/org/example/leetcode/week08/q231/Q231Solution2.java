package org.example.leetcode.week08.q231;

public class Q231Solution2 {
    public boolean isPowerOfTwo(int n) {
        return n <= 0? false : ((n & (-n)) == n);
    }
}
