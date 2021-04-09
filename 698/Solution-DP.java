class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // state : dp[mask] is subsetSum(mask) % target
        // dp[0] = 0;
        // dp[mask | 1 << i] = dp[mask] + nums[i] 
        // under the condition that dp[mask] + nums[i] <= target 
        // and nums[i] is not used in mask, namely mask & (1 << i) is 0
        // return last element of dp is 0
        // there are 2^N states, where N = nunms.length
        
        int N = nums.length,
            states = (int)Math.pow(2, N);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        
        int[] dp = new int[states];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int mask = 0; mask < dp.length; mask++) {
            if (dp[mask] == -1) continue;
            for (int i = 0; i < N; i++) {
                if (!used(mask, i) && (dp[mask] + nums[i]) <= target) {
                    dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }
        
        return dp[dp.length - 1] == 0;
    }
    
    private boolean used(int mask, int i) {
        return (mask & (1 << i)) != 0;
    }
}
