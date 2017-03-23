public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k < 1) return 0;
        // idea: sliding window
        // hash table : char -> last (right most) index of char
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxLen = 0;
        while(end < s.length()){ // loop invariant : [start, end) will be taken care of 
            char c = s.charAt(end);
            if(map.size() >= k && !map.containsKey(c)){
                // find the character to remove from sliding window
                int ri = Integer.MAX_VALUE;
                for(int i : map.values()){
                    ri = Math.min(ri, i);
                }
                char rc = s.charAt(ri);
                map.remove(rc);
                start = ri + 1;
            }
            
            map.put(c, end);
            end++;
            maxLen = Math.max(end - start, maxLen);
        }
        return maxLen;
    }
}