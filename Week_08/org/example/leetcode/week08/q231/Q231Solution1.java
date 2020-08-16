package org.example.leetcode.week08.q231;

public class Q231Solution1 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int numOf1 = 0;
        while (n != 0) {
            numOf1++;
            n &= (n - 1);
        }
        return numOf1 == 1;
    }
}
