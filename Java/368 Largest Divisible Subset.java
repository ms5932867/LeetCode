public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre   = new int[nums.length];
        int maxIndex = 0;
        //for each element in nums, find the length of largest subset it has.
        for (int i = 0; i < nums.length; i++){
            count[i] = 1;
            pre[i]  = -1;
            for (int j = i-1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]){
                    count[i] = count[j] + 1;
                    pre[i] = j;
                }
            }
            
            if(count[i] > count[maxIndex]){
                maxIndex = i;
            }
        }
        
        while(maxIndex >= 0){
            res.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return res;
    }
}