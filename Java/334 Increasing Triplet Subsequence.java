public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        // idea : same as #300
        int rec1 = Integer.MAX_VALUE,
            rec2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= rec1){
                rec1 = num;
            }
            else if(rec1 < num && num <= rec2){
                rec2 = num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}