// https://leetcode.com/problems/paint-house-ii/
class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length,
            k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int d = 1; d < k; d++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][ (j + d) % k]);
                }
                dp[i][j] += costs[i][j];
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
