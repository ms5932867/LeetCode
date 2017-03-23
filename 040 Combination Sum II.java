/* 40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Show Tags
Show Similar Problems

*/

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        nums = candidates;
        Arrays.sort(nums);
        backtrack(target, 0);
        return res;
    }
    
    private void backtrack(int target, int s){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(tmp)); // new solution
            return;
        }
        
        for(int i = s; i < nums.length; i++){
            if(i > s && nums[i] == nums[i - 1]) continue; // abandon
            tmp.add(nums[i]);
            backtrack(target - nums[i], i + 1); // next partial
            tmp.remove(tmp.size() - 1); // backtrack
        }
    }
}