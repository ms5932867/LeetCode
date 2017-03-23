/* 254. Factor Combinations
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 2) return res;
        getFactors(res, new ArrayList<Integer>(), 2, n);
        return res;
    }
    
    public void getFactors(List<List<Integer>> result, List<Integer> cur, int start, int n){
        if(n == 1 && cur.size() > 1){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                cur.add(i);
                getFactors(result, cur, i, n/i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}