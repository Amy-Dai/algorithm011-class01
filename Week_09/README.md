力扣第63题“不同路径II”的动态转移方程
===================================
设f(i,j)表示从坐标（0，0）到坐标（i,j)的走法个数<br>
u(i,j)表示坐标（i,j）是否可行<br>
u(i，j) = 0，当坐标(i,j)非0<br>
u(i，j) = 1，当坐标(i,j)是0<br>
由于机器人要么向右，要么向下，而且当坐标(i,j)非0时，f(i,j)必然为0<br>
因此，当坐标（i,j)为0时，对于f(i,j)有两种方式可以转变而来:<br>
1) f(i-1, j)<br>
2) f(i, j-1)<br>
所以，当坐标（i,j)为0时，f(i,j)=f(i,j-1)+f(i-1,j)<br>

参考<br>
https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution<br>
More explanation:<br>
This is a typical 2D DP problem, we can store value in 2D DP array, but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j], we don't need to store the whole 2D table, but instead store value in an 1D array, and update data by using dp[j] = dp[j] + dp[j - 1], (where here dp[j] corresponding to the dp[i - 1][j]) and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array)
