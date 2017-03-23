public class Solution {
    public int numWays(int n, int k) {
        if(n < 1) return 0;
        if(n == 1) return k;
        if(n == 2) return k*k;
        int diffColor = k * (k - 1),
            sameColor = k;
        for(int i = 3; i <= n; i++){
            int tmp = diffColor;
            diffColor = sameColor * (k - 1) + diffColor * (k - 1);
            sameColor = tmp;
        }
        return diffColor + sameColor;
    }
}