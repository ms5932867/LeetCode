/* 78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<Integer>();
    int[] nums;
    public List<List<Integer>> subsets(int[] _nums) {
        nums = _nums;
        Arrays.sort(nums);
        backtrack(0);
        return res;
    }
    
    private void backtrack(int s){
        res.add(new ArrayList<>(tmp)); // new solution
        for(int i = s; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(i + 1);
            tmp.remove(tmp.size() - 1); // backtrack
        }
    }
}