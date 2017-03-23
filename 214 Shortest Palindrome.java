public class Solution {
    public String shortestPalindrome(String s) {
        // find longest Palindrome from beginning, then reverse suffix and put at front
        char[] chrs = s.toCharArray();
        int end = chrs.length - 1;
        while(end > 0){
            if(isPalindrom(chrs, 0, end)) break;
            else{
                end--;
            }
        }
        if(end == chrs.length - 1) return s;
        
        String p = new String(chrs, 0, end + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(chrs, end + 1, chrs.length - (end + 1));
        String res = p + sb.toString();
        return sb.reverse().toString() + res;
    }
    
    private boolean isPalindrom(char[] chrs, int i, int j){
        while(i < j){
            if(chrs[i] != chrs[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}