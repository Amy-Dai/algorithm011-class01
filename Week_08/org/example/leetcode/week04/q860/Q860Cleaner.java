package org.example.leetcode.week04.q860;

public class Q860Cleaner {
    public boolean lemonadeChange(int[] bills) {
        int fiveBillCount = 0;
        int tenBillCount = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveBillCount++;
                    break;
                case 10:
                    tenBillCount++;
                    fiveBillCount--;
                    break;
                case 20:
                    if (tenBillCount > 0) {
                        tenBillCount--;
                        fiveBillCount--;
                    } else {
                        fiveBillCount -= 3;
                    }
            }
            if (fiveBillCount < 0) {
                return false;
            }
        }
        return true;
    }
}
