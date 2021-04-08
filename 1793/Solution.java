class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length,
            l = k, 
            r = k, 
            res = 0;
        
        while (true) {
            int curMin = Math.min(nums[r], nums[l]);
            while (l > 0 && nums[l - 1] >= curMin) l--;
            while (r < n - 1 && nums[r + 1] >= curMin) r++;
            
            res = Math.max(res, curMin * (r - l + 1));
            
            if (l > 0 && r < n - 1) {
               if (nums[l - 1] < nums[r + 1]) {
                   r++;
               } else {
                   l--;
               }
            } else if (l == 0 && r < n - 1) {
                r++;
            } else if (l > 0 && r == n - 1) {
                l--;
            } else {
                break;
            }
        }
        return res;
    }
}
