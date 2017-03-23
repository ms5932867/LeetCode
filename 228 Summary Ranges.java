public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List <String> ans = new ArrayList<String>();
        for(int L = 0, R = 0;R < nums.length; R++){
            L = R;
            while (R + 1< nums.length && nums[R+1] == nums[R] + 1){
                R++;
            }
            if(L == R) ans.add(Integer.toString(nums[L]));
            else ans.add(nums[L] + "->" + nums[R]);
        }
        return ans;
    }
}