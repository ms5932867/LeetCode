class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int t = sum / k;
        int i = nums.length - 1;
        while (i >= 0 && nums[i] == t) {
            i--;
            k--;
        }
        
        int[] fill = new int[k];
        Arrays.fill(fill, t);
        return dfs(nums, fill, i, t);
    }
    
    private boolean dfs(int[] nums, int[] fill, int e, int t) {
        if (e < 0)
            return true;
        int c = nums[e];
        for (int i = 0; i < fill.length; i++) {
            if (fill[i] >= c) {
                fill[i] -= c;
                if (dfs(nums, fill, e - 1, t)) return true;
                fill[i] += c;
            }
            
            if (fill[i] == t) break; // this optmization is from official solution, took some time for me to understand
        }
        return false;
    }
}
