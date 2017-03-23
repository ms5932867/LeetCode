// Implement pow(x, n)
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        long N = (long) n;
        long exp = N < 0 ? -N : N;
        double result = exp%2 == 0 ? myPow(x*x, (int)(exp/2)) : myPow(x*x, (int)(exp/2)) * x;
        return n < 0 ? 1/result : result;
    }
}