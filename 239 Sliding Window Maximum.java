/* 239. Sliding Window Maximum
Given an array nums, there is a sliding window of size k which is moving from the very 
left of the array to the very right. You can only see the k numbers in the window. 
Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) return new int[]{};
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // store the index of max number in window
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.addLast(i);
            if(i - k + 1>= 0) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}