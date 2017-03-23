public class Solution {
    public int[] countBits(int num) {
        // idea 1 : f(n) = f(n/2) + n%2
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i++)
            res[i] = res[i>>1] + i%2;
        return res;
        // idea 2 : n &= (n-1) will remove the last bit in n
        /*
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i++)
            res[i] = res[i&(i-1)] + 1;
        return res;
        */
    }
}