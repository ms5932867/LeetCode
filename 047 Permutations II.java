/* 47	Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
*/
public class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> tmp, boolean[] used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                tmp.add(nums[i]);
                used[i] = true;
                backtrack(nums, tmp, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}