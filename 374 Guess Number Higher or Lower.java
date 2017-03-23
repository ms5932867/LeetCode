/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j){
            int m = i + ((j - i) >> 1);
            if(guess(m) == 0) return m;
            if(guess(m) == 1) i = m + 1; 
            else j = m - 1;
        }
        return i;
    }
}