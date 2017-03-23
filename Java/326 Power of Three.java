public class Solution {
    int _max = (int)Math.pow(3,19);
    public boolean isPowerOfThree(int n) {
        return n > 0 && _max % n == 0;
    }
}