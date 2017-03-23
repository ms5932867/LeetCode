/* 8	String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        
        str = str.trim(); // leading space
        int ans = 0, sign = 1, i = 0;
        
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) { // possible sign
            if(str.charAt(i) == '-') sign = -1; 
            i++;
        }
        
        while(i < str.length() && str.charAt(i) >='0' && str.charAt(i) <= '9'){
            if (ans > Integer.MAX_VALUE / 10 || 
                (ans == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)){ 
				// overflow
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ans = ans * 10 + str.charAt(i) - '0';
            i++;
        }
        return ans * sign;
    }
}