/* 152. Maximum Product Subarray
Find the contiguous subarray within an array 
(containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] A) {
        int maxP = A[0], minP = A[0], maxProd = A[0];
        for(int i = 1; i < A.length; i++){
            int maxC = Math.max(Math.max(maxP * A[i], minP * A[i]), A[i]);
            int minC = Math.min(Math.min(maxP * A[i], minP * A[i]), A[i]);
            maxProd = Math.max(maxProd, maxC);
            maxP = maxC;
            minP = minC;
        }
        return maxProd;
    }
}