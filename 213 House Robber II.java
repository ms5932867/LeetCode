/* 213. House Robber II
After robbing those houses on that street, the thief has found himself a new place for his 
thievery so that he will not get too much attention. This time, all houses at this place are 
arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        // idea : this problem can be treated as two robber problem
        // you can rob [0, n-2] or [1, n-1] now
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    
    private int rob(int[] nums, int start, int end){
        int currMax = 0, prevMax = 0;
        for(int i = start; i <= end; i++){
            int tmp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = tmp;
        }
        return currMax;
    }
}