/* 216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.

Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<Integer>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return res;
    }
    
    private void backtrack(int k, int n, int s){
        if(tmp.size() == k &&sum == n){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        if(sum > n) return;
        
        for(int i = s; i <= 9; i++){
            tmp.add(i);
            sum += i;
            backtrack(k, n, i + 1);
            sum -= i;
            tmp.remove(tmp.size() - 1);
        }
    }
}