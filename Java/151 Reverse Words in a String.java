/* 151	Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
public class Solution {
    public String reverseWords(String s) {
        String[] tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = tmp.length - 1; i >= 0; i--)
            res += tmp[i] + " ";
        return res.trim();
    }
}