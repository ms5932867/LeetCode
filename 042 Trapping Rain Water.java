/* 42. Trapping Rain Water
Given n non-negative integers representing an elevation map 
where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
public class Solution {
    public int trap(int[] height) {
        // idea: DP
        // Keep the highest bar from left and right
        // water can be stored if current bar is lower than left and right highest
        if(height == null || height.length < 3) return 0;
        int i = 0, j = height.length - 1, res = 0;
        int lh = height[0], rh = height[height.length - 1];
        while(i <= j){
            lh = Math.max(lh, height[i]);
            rh = Math.max(rh, height[j]);
            if(lh < rh){
                res += lh - height[i];
                i++;
            }
            else{
                res += rh - height[j];
                j--;
            }
        }
        return res;
    }
}