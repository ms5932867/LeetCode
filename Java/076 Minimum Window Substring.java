/* 76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S 
which will contain all the characters in T in complexity O(n).

Given a string S and a string T, find the minimum window in S 
which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be 
only one unique minimum window in S.
*/
public class Solution {
    public String minWindow(String s, String t) {
        // idea: sliding window
        int[] need = new int[256]; // char int t -> remainig number of existence needed in window
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need[(int)c]++;
        }
        
        int start = 0, end = 0;
        int count = t.length(), minLen = Integer.MAX_VALUE, m_start = 0;
        
        while(end < s.length()){
            char c = s.charAt(end++);
            if(need[(int)c]-- > 0) count--;
            
            while(count == 0){
                if(end - start < minLen){
                    minLen = end - start;
                    m_start = start;
                }
                char r = s.charAt(start++);
                if(++need[(int)r] > 0) count++;
            }                      
        }        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(m_start, m_start + minLen);        
    }
}