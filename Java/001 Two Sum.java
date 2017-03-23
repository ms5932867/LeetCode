/* 1	Two Sum
Given an array of integers, return indices of the two numbers 
such that they add up to a specific target.
You may assume that each input would have exactly one solution.
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int[] {map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No valid solution");
    }
}