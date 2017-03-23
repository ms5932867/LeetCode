/* 300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there 
may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // idea : for a given length of subsequence, we only need to record the smallest last
		// number in all possible choice.
        // For each new element, if it's bigger than the recoreded number
        //  it can be virtually append to a current longest subsequence, 
		// so that the result increases by 1. 
        // Replace the recoreded number with the new element to update.
        int[] record = new int[nums.length]; //record[i] : 
        int len = 0;
        for(int num : nums){
            // find the insert postion : record[k] < n <= record[k+1], record[k+1] = n;
            int i = 0, j = len;
            while(i < j){
                int m = i + (j - i) / 2;
                if(record[m] < num){
                    i = m + 1;
                }
                else
                    j = m;
            } 
            record[i] = num;
            if(i == len) len++;
        }
        return len;
    }
}