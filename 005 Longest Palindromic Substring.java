/* 5	Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = findPalindrome(s, i, i),
                len2 = findPalindrome(s, i, i + 1),
                len  = Math.max(len1, len2);
            if (len > maxLen){
                start = (len % 2 == 0) ? i - (len - 2)/2 : i - (len - 1)/2;
                end = (len % 2 == 0) ? i + len/2 : i + (len - 1)/2;
                maxLen = len;
            }    
        }
        return s.substring(start, end + 1);
    }
    
    private int findPalindrome(String s, int start, int end){
        int L = start, R = end;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}