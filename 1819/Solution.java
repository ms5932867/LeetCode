// https://leetcode.com/contest/weekly-contest-235/problems/number-of-different-subsequences-gcds/
// Reference: https://leetcode.com/problems/number-of-different-subsequences-gcds/discuss/1141436/

class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        for (int i = 1; i <= 200000; i++) {
            int gcd = 0;
            for (int x = i; x <= 200000; x += i) {
                if (set.contains(x)) {
                    gcd = gcd == 0 ? x : gcd(gcd, x);
                }
            }
            
            if (gcd == i) ans++;
        }
        return ans;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
