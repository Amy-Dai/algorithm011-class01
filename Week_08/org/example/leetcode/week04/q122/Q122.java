package org.example.leetcode.week04.q122;

public class Q122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (null == prices || prices.length <= 1) {
            return profit;
        }
        int tmpProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            tmpProfit = prices[i] - prices[i - 1];
            profit = tmpProfit > 0? (profit + tmpProfit) : profit;
        }
        return profit;
    }
}
