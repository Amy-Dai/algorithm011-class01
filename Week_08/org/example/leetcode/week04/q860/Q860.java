package org.example.leetcode.week04.q860;

public class Q860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveBillCount = 0;
        int tenBillCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveBillCount++;
            } else if (bill == 10) {
                if (fiveBillCount > 0) {
                    fiveBillCount--;
                    tenBillCount++;
                } else {
                    return false;
                }
            } else {
                if (tenBillCount > 0 && fiveBillCount > 0) {
                    tenBillCount--;
                    fiveBillCount--;
                } else if (fiveBillCount > 2) {
                    fiveBillCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
