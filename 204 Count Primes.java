/* 204. Count Primes
Description:
Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        for(int i = 2; i * i < n; i++){
            if(notPrime[i]) continue;
            for(int j = i * i; j < n; j+=i){
                notPrime[j] = true;
            }
        }
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]) ans++;
        }
        return ans;
    }
}