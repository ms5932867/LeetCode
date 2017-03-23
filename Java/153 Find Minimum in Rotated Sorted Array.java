/* 153	Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2; 
			// mid and low might be equal, 
			//so it's better to compare mid and high
            if(nums[mid] < nums[high]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return nums[high];
    }
}