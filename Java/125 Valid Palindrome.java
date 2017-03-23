/* 125	Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

// Have you consider that the string might be empty? This is a good question to ask during an interview.
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            char c1 = s.charAt(i),
                 c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c1)){
                i++;
            }
            else if(!Character.isLetterOrDigit(c2)){
                j--;
            }
            else{
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}