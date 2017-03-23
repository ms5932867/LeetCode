/* 3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, start = 0, end = 0; // sliding window = s[i,j] 
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // <char, index>
        while(end < s.length()){
            char c = s.charAt(end);
            
            if(map.containsKey(c)){
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, end++);
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}