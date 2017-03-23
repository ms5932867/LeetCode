public class Solution {
    public int numSquares(int n) {
        int[] mem = new int[n + 1];
        for(int i = 0; i < mem.length; i++){ mem[i] = i; }
        
        for(int k = 2; k * k <= n; k++){
            for(int i = k * k; i <= n; i++){
                mem[i] = Math.min(mem[i], 1 + mem[i - k * k]);
            }
        }
        
        return mem[n];
    }
}