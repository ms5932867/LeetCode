/* 367. Valid Perfect Square
Given a positive integer num, write a function which returns 
True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
Credits:
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        // binary search
        int i = 2, j = num /2;
        while(i < j){
            int m = i + (j - i) / 2;
            long m2 = (long)(m) * (long)(m);
            if(m2 == num) return true;
            if(m2 > num){ j = m - 1; }
            else {i = m + 1;}
        }
        return num == i * i;
    }
}