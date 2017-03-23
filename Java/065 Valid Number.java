/* 65. Valid Number
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s == null) {
            return false;
        }
        s = s.trim();
        
        if(s.length() == 0) {
            return false;
        }
        
        char[] charArr = s.toCharArray();
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasDigit = false;
        
        char c = ' ', prev = ' '; //newly added, to solve the previous char like e+
        
        for(int i = 0; i < charArr.length; i++) {
            c = charArr[i];
            if(c == '-' || c == '+') {
                //+- can only appear at the begining or after e
                if(i != 0 && prev != 'e') {
                    return false;
                }
            }
            else if(c == '.') {
                if(hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            }
            else if(c == 'e') {
                if(hasE || !hasDigit) {
                    return false;
                }
                hasE = true;
            }
            else if(c >= '0' && c <= '9') {
                hasDigit = true;
            }
            else {
                return false;
            }
            prev = c;
        }
        if(c == 'e' || c == '+' || c == '-') {
            return false;
        }
        if(c == '.') {
            //we don't accpet . or [-+e].
            if(charArr.length == 1 || (charArr[charArr.length - 2] < '0' || 
				charArr[charArr.length - 2] > '9')) {
                return false;
            }
        }
        return true;
    }
}