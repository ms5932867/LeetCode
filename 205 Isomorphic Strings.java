/* 205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving 
the order of characters. No two characters may map to the same character but a 
character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/
public class Solution {
    // idea : store the last position each character appears
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for(Integer i = 0; i < s.length(); i++){
            char sc = s.charAt(i),
                 tc = t.charAt(i);
            if(sMap.containsKey(sc) && !sMap.get(sc).equals(tc)) return false;
            if(tMap.containsKey(tc) && !tMap.get(tc).equals(sc)) return false;
            tMap.put(tc, sc);
            sMap.put(sc, tc);
        }
        return true;
    }
}