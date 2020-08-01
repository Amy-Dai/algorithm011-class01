package org.example.leetcode.week06.q64;

public class Q64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        System.arraycopy(grid, 0, dp, 0, grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                } else if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j] += Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
