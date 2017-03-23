/* 186	Reverse Words in a String II 
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/
public class Solution {
    public void reverseWords(char[] s) {
        //idea swap the entire string, then swap each word
        reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
            if(s[i] != ' ' && i == s.length - 1){
                reverse(s, start, i);
            }
        }
    }
    
    private void reverse(char[] s, int start, int end){
        int i = start, j = end;
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}