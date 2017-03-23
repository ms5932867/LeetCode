public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int mask = 1, count = 0;
        while(mask > 0){
            if((mask & n) > 0) count++;
            mask = mask << 1;
        }
        return count == 1;
    }
}