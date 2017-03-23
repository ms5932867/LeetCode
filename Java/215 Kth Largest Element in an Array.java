/* 215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element 
in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length);
        int i = 0;
        while(i < nums.length){
            heap.offer(nums[i++]);
        }
        i = nums.length - k;
        while(i-- > 0){
            heap.poll();
        }
        return heap.poll();
    }
}