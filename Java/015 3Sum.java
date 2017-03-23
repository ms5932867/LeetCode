/* 	15	3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;){
            //if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int v = nums[i] + nums[j] + nums[k];
                if(v == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(nums[j++] == nums[j] && j < k);
                    while(nums[k--] == nums[k] && j < k);
                }
                else if(v > 0){
                    while(nums[k--] == nums[k] && j < k);
                }
                else{
                    while(nums[j++] == nums[j] && j < k);
                }
            }
            while(i + 2 < nums.length && nums[i++] == nums[i]);
        }
        
        return res;
    }
}