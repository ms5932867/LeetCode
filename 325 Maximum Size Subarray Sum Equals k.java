public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // idea: hash table stores the first index where a summation is reached during sum(nums[0..i])
        // for a new element at i, if k - sum(nums[0...i]) is in hash table, subarray is found
        Map<Integer, Integer> map = new HashMap<>(); // sum(nums[0...i]) -> i
        int sum = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) maxLen = i + 1;
            if(map.containsKey(sum - k)) maxLen = Math.max(maxLen, i - map.get(sum - k));
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        
        return maxLen;
    }
}