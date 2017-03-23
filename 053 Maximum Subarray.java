/* 53	Maximum Subarray
Find the contiguous subarray within an array 
(containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/


public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return 0;
        // maxSub(0...i) : maxSubArray subproblem ending in A[i]
        // idea : maxSub(0...i) = maxSub(0...i-1) > 0 ? maxSub(0...i-1) + A[i] : A[i]
        // Solution 1 : allocate extra space, easier to understand
        /*
        int[] m = new int[A.length];
        m[0] = A[0];
        int maxSub = m[0];
        for(int i = 1; i < A.length; i++){
            m[i] = m[i-1] > 0 ? m[i-1] + A[i] : A[i];
            maxSub = Math.max(maxSub, m[i]);
        }
        return maxSub;
        */
        // Solution 2 : we actually only need to store one sub-problem
        int prev = A[0], maxSub = A[0];
        for(int i = 1; i < A.length; i++){
            int curr = Math.max(prev + A[i], A[i]);
            maxSub = Math.max(curr, maxSub);
            prev = curr;
        }
        return maxSub;
    }
}