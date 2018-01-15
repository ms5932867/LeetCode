/* 46	Permutations
Given a collection of distinct numbers, return all possible permutations.
*/
public class Solution {
    // backtrack summary : a method to find all solutions under certain constrains
    // 1. when a new solution is find, copy it to a new object and add it into the final result
    // 2. result could be put outside the helper function, so that it won't be passed during recursive call 
    // 3. abandon the partial candidates, this is the most important part
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmpRes = new ArrayList<Integer>();
    int[] nums;
    public List<List<Integer>> permute(int[] _nums) {
        nums = _nums;
        backTrack();
        return res;
    }
    
    private void backTrack(){
        if(tmpRes.size() == nums.length){
            res.add(new ArrayList<>(tmpRes)); // new solution
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(tmpRes.contains(nums[i])) continue; // abandon
            tmpRes.add(nums[i]);
            backTrack();
            tmpRes.remove(tmpRes.size() - 1); // backtrack
        }

    }
}