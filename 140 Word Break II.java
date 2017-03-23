/* 140. Word Break II
Given a string s and a dictionary of words dict, add spaces in s to construct a 
sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Given a string s and a dictionary of words dict, add spaces in s to construct 
a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    List<String> res = new ArrayList<>();
    Set<String> dict;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // idea: backtracking, since all results is needed
        // in each step, there is an starting point in s, the space could be 
		put any place after starting point
        if (!canBreak(s, wordDict)) // there will be TLE if we skip this check
            return res;
        dict = wordDict;
        workBreak(s, 0, "");
        return res;
    }
    
    private void workBreak(String str, int s, String tmp){
        if(s >= str.length()){
            res.add(tmp);
            return;
        }
        for(int e = s + 1; e <= str.length(); e++){
            String curr = str.substring(s, e);
            if(dict.contains(curr)){
                workBreak(str, e, tmp + (tmp.length() == 0? "" : " ") + curr);
            }
        }
    }
    
    private boolean canBreak(String s, Set<String> dict) {
      if (s == null || s.length() == 0) return false;
      
      int n = s.length();
      
      // dp[i] represents whether s[0...i] can be formed by dict
      boolean[] dp = new boolean[n];
      
      for (int i = 0; i < n; i++) {
          for (int j = 0; j <= i; j++) {
              String sub = s.substring(j, i + 1);
              
              if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                  dp[i] = true;
                  break;
              }
          }
      }
      
      return dp[n - 1];
  }
}