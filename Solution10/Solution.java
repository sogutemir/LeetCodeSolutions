class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {

                    dp[i][j] = dp[i][j - 2];
                    
                    if (matches(s.charAt(i - 1), p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s.charAt(i - 1), p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    private boolean matches(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isMatch("aa", "a")); 
        System.out.println(sol.isMatch("aa", "a*")); 
        System.out.println(sol.isMatch("ab", ".*")); 
    }
}
