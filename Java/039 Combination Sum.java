/* 039 Combination Sum.java
// Given a set of candidate numbers (C) and a target number (T), 
// find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.
*/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> tmp, int target, int s){
        if(target < 0) return; // abandon
        if(target == 0) { res.add(new ArrayList<>(tmp)); return;} // new solution
        for(int i = s; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(nums, tmp, target - nums[i], i);
            tmp.remove(tmp.size() - 1); // backtrack
        }
    }
}