public class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j] =
        //          1. s[i - 1] == p[j - 1] => dp[i - 1][j -1]
        //          2. p[j - 1] == '.' same as 1.
        //          3. p[j - 1] == '*', then we need to consider p[j - 2], since '*' will work together with its previous char
        //              3.1 p[j - 2] == '*' => dp[i][j - 2], recursively
        //              3.2 p[j - 2] == '.' => same as p[j - 2] == s[i - 1]
        //              3.3 p[j - 2] == s[i - 1] => dp[i][j - 2] || dp[i-1][j-2] || dp[i-1][j]
        //              3.4 p[j - 2] is some char other than wildcard and s[i - 1] => dp[i][j - 2]
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // initialize dp[0][j]
        for(int j = 2; j <= n; j++){
            char c = p.charAt(j - 1);
            if(c == '*'){ dp[0][j] = dp[0][j - 2];}
        }
        
        // populate dp[1...m][1...n]
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) ||p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    if(j == 1) return false;
                    if(p.charAt(j - 2) == '*' || (p.charAt(j - 2) != '.' && p.charAt(j - 2) != s.charAt(i - 1))){ 
                        dp[i][j] = dp[i][j - 2];
                    }
                    else{
                        dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}