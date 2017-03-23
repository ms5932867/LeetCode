public class Solution {
    public int integerBreak(int n) {
        // idea: find the derivative of x^(n/x), so that the optimal is x=e, so 2 or 3 should be used
        if(n == 2) return 1;
        if(n == 3) return 2;
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }
}