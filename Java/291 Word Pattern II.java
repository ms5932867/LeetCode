/* 291. Word Pattern II
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between 
a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
*/

public class Solution {
    Map<Character, String> map;
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap<>();
        return backtrack(pattern, str);
    }
    
    private boolean backtrack(String pattern, String str){
        if(str.length() == 0 && pattern.length() == 0) return true;
        if(pattern.length() == 0 || str.length() == 0) return false;
        char k = pattern.charAt(0);
        String nPattern = pattern.substring(1);
        
        for(int i = 1; i <= str.length(); i++){
            String v = str.substring(0, i);
            String nString = i == str.length() ? "" : str.substring(i);
            if(map.containsKey(k)){
                if(map.get(k).equals(v)) return backtrack(nPattern, nString);
            }
            else{
                if(!map.containsValue(v)){
                    map.put(k, v);
                    if(backtrack(nPattern, nString)) return true;
                    map.remove(k);
                }
            }
        }
        return false;
    }
}