/* 268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
*/
public class Solution {
    public int missingNumber(int[] nums) {
        // idea: a = a^b^b, xor is commutative and 
        // if (nums[i]=i) res = res ^ i ^ nums[i]
        // res = 0^1^2^...^n^nums[0]^nums[1]^...nums[last]
        int res= 0;
        for(int i = 0; i < nums.length; i++)
            res = res ^ i ^ nums[i];
        return res ^ (nums.length);
    }
}