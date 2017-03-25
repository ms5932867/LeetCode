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
        
        if(mA < mB){//A.length + B.length >= k, so mA and mB cannot both be Integer.MAX_VALUE
            return getKth(A, sA + k/2, B, sB, k - k/2);
        }
        else{
            return getKth(A, sA, B, sB + k/2, k - k/2);
        }
    }
}

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int totalEle = A.length + B.length;
		if (totalEle == 0) return 0;
		if (totalEle % 2 == 1) return findKth(A, 0, A.length, B, 0, B.length, (totalEle + 1) / 2);
		else return (findKth(A, 0, A.length, B, 0, B.length, totalEle/2) + 
				findKth(A, 0, A.length, B, 0, B.length, totalEle/2 + 1))/2;
    }
    
    private static double findKth(int A[], int sA, int m, int B[], int sB, int n, int k){
		if (sA > A.length - 1)	return B[sB + k - 1];
		if (sB > B.length - 1)	return A[sA + k - 1];
		if (k == 1)	return Math.min(A[sA], B[sB]); // boundary
		int numA = Math.min(k/2, m), numB = Math.min(k/2, n);
		if (A[sA + numA - 1] <= B[sB + numB - 1])
			return findKth(A, sA + numA, m - numA, B, sB, n, k - numA);
		else
			return findKth(A, sA, m, B, sB + numB, n - numB, k - numB);
	}
}