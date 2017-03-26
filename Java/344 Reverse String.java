public class Solution {
    public String reverseString(String s) {
        if(s == null) return s;
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while(i < j){
            char tmp = str[i];
            str[i++] = str[j];
            str[j--] = tmp;
        }
        
        return new String(str);
    }
}