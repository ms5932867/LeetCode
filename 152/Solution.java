class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0],
            max = nums[0],
            res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i],
                v1 = num * min,
                v2 = num * max;
            min = Math.min(Math.min(num, v1), v2);
            max = Math.max(Math.max(num, v1), v2);
            res = Math.max(res, max);
        }
        
        return res;
    }
}
