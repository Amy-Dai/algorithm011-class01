package org.example.leetcode.week09.q63;

public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 0? 1 : 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 0) {
                    dp[j] = 0;
                } else if ((j - 1 >= 0) && (obstacleGrid[i][j - 1] == 0)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
