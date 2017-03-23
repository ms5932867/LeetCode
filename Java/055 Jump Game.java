/* 	55	Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int leftMostGoodPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] + i >= leftMostGoodPos){
                leftMostGoodPos = i;
            }
        }
        return leftMostGoodPos == 0;
    }
}