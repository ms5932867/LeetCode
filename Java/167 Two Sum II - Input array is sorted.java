/* 167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that 
they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j){
            int v = numbers[i] + numbers[j];
            if(v ==  target){
                return new int[]{i + 1,j + 1};
            }
            else if(v > target){
                j--;
            }
            else{
                i++;
            }
        }       
        return new int[]{};
    }
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int s = 0; s < numbers.length - 1; s++){
            int bs = BS(numbers, s + 1, numbers.length - 1, target - numbers[s]);
            if(bs > s){ return new int[]{s + 1, bs + 1}; }
        }
        return new int[]{};
    }
    
    private int BS(int[] nums, int start, int end, int target){
        if(start < 0 || end >= nums.length) return -1;
        while(start <= end){
            int m = start + (end - start) / 2;
            if(nums[m] == target) return m;
            if(nums[m] > target) end = m - 1;
            else start = m + 1;
        }
        return -1;
    }
}