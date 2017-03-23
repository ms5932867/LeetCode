/* 242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] str1 = s.toCharArray(),
               str2 = t.toCharArray();
        int[] m = new int[256];     
        int n = s.length();
        for(int i = 0; i < n; i++){
            m[str1[i]]++;
            m[str2[i]]--;
        }
        for(int i = 0; i < m.length; i++){
            if(m[i] != 0) return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray(),
               str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}