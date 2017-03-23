/* 	4	Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // recursive, cut input arrayin each step
        int m = A.length,
            n = B.length;

        if((m + n) % 2 == 1)
            return getKth(A, 0, B, 0, (m + n + 1)/2);
        else
            return (getKth(A, 0, B, 0, (m + n)/2) + getKth(A, 0, B, 0, (m + n)/2 + 1))/2;

    }
    
    private double getKth(int[] A, int sA, int[] B, int sB, int k){
        // find kth element in A[sA...] and B[sB...]
        if(sA > A.length - 1) return B[sB + k - 1];
        if(sB > B.length - 1) return A[sA + k - 1];
        if(k == 1) return Math.min(A[sA], B[sB]);
        
        int mA = Integer.MAX_VALUE,
            mB = Integer.MAX_VALUE;
        if(sA + k/2 - 1 < A.length) mA = A[sA + k/2 - 1];
        if(sB + k/2 - 1 < B.length) mB = B[sB + k/2 - 1];
        
        if(mA < mB){
            return getKth(A, sA + k/2, B, sB, k - k/2);
        }
        else{
            return getKth(A, sA, B, sB + k/2, k - k/2);
        }
    }
}