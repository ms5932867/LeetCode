/*
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = helper(nums, target),
            second = helper(nums, target + 1);
        if(first >= 0 && first < nums.length && nums[first] == target) return new int[]{first, second - 1};
        return new int[]{-1, -1};
    }
    
    private int helper(int[] nums, int target){
        if(nums[nums.length - 1] < target) return nums.length;
        // return the first element greater or equal to target
        int i = 0, j = nums.length - 1;
        while(i < j){
            int m = i + (j - i)/2;
            if(nums[m] < target){i = m + 1;}
            else if(nums[m] == target) {j = m;}
            else{ j = m;}
        }
        return nums[i] >= target ? i : -1;
    }
}