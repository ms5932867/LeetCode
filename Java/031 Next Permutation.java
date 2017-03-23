public class Solution {
    public void nextPermutation(int[] nums) {
        // idea: find right-most pair a[i] > a[i - 1], find first number after a[i] which is greater than a[i - 1], say a[j]
        // swap a[i - 1] and a[j], reverse a[i...] to ascending order
        // desendeing and ascending order are greatest and smallest permutation
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){ i --; }
        
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){ j--; }
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);
        }
        else{
            reverse(nums, 0, nums.length - 1);
        }
    }
    
    private void reverse(int[] nums, int s, int e){
        while(s < e){
            swap(nums, s, e);
            s++;
            e--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}