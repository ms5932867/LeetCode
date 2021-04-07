// https://leetcode.com/problems/paint-house/

class Solution {
    public int minCost(int[][] costs) {
        // red = 0, blue = 1, green = 2
        // dp[i][j] optimal result of (minimum cost) paint house i with color j
        // dp[i][j] = min{dp[i - 1][k] + cost[i][j]} for k != j k = 0,1,2, i > 0
        // init : dp[0][k] = costs[0][k] k = 0,1,2
        // result min{dp[-1][k]} k = 0,1,2
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i - 1][ (j + 1) % 3], dp[i - 1][ (j + 2) % 3]);
            }
        }
        
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
