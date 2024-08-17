class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] dp = new long[n];
        
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            long[] leftToRight = new long[n];
            long[] rightToLeft = new long[n];
            long[] newDp = new long[n];
            
            leftToRight[0] = dp[0];
            for (int j = 1; j < n; j++) {
                leftToRight[j] = Math.max(leftToRight[j - 1] - 1, dp[j]);
            }
            
            rightToLeft[n - 1] = dp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightToLeft[j] = Math.max(rightToLeft[j + 1] - 1, dp[j]);
            }
            
            for (int j = 0; j < n; j++) {
                newDp[j] = points[i][j] + Math.max(leftToRight[j], rightToLeft[j]);
            }
            
            dp = newDp;
        }
        
        long result = 0;
        for (long score : dp) {
            result = Math.max(result, score);
        }
        
        return result;
    }
}
