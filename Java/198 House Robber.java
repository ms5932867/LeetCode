/* 198. House Robber
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have security system 
connected and it will automatically contact the police if two adjacent houses were 
broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
    public int rob(int[] nums) {
        // idea : f(k) = max(f(k-2) + Ak, f(k-1))
        int currMax = 0, prevMax = 0; // f(0) = 0, f(-1) = 0
        for(int x: nums){
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}