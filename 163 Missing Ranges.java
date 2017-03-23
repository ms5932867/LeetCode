public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res =  new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            int start = i == 0 ? lower : nums[i-1] + 1;
            int end = i == nums.length ? upper: nums[i] - 1;
            if(start == end){
                res.add("" + start + "");
            }else if(start < end){
                res.add(start + "->" + end);
            } 
        }
        return res;
    }
}