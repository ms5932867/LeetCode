/* 168. Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while (n != 0) {
            ret = (char)('A'+(--n)%26) + ret;
            n /= 26;
        }
        return ret;
    }
}