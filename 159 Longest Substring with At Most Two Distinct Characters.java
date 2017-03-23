public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // idea : sliding window
        // use hash table to store mapping char -> last(right-most) existence index
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        // loop invariant : [start, end) is taken cared of before and after each loop
        // each step will consider a new element at s[end]
        // update the start if s[end] is not in hash table and size of hash table is not less than 2
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.size() >= 2 && !map.containsKey(c)){
                int leftMost = Integer.MAX_VALUE;
                for(int i : map.values()){
                    leftMost = Math.min(leftMost, i);
                }
                char rc = s.charAt(leftMost);
                map.remove(rc);
                start = leftMost + 1;
            }
            map.put(c, end);
            end++;
            maxLen = Math.max(maxLen, end - start);
        }
        
        return maxLen;
    }
}