package org.example.leetcode.week04.q122;

public class Q122Cleaner {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length <= 1) {
            return profit;
        }
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i -1], 0);
        }
        return profit;
    }
}
