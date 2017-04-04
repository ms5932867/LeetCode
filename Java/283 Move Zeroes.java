public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        while(i < nums.length) nums[i++] = 0;
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; j < nums.length; j++){
            if(nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }
}