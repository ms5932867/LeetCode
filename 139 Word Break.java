/* 139. Word Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code"
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // idea: DP
        // memory : dp[i] = whether s[0...i] could satisfy the requirement
        // return m[s.length() - 1]
        // m[i] = true, if exists an j = [0..i], (j == 0 || m[j - 1] == true) && s[j, i] is in dict
        
        boolean[] m = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if((j == 0 || m[j - 1]) && wordDict.contains(s.substring(j, i + 1))){
                    m[i] = true;
                    break;
                }
            }
        }
        return m[s.length() - 1];
    }
}