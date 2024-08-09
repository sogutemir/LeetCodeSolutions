public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        int[][] dp = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices1 = {2, 4, 1};
        System.out.println(sol.maxProfit(2, prices1));

        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println(sol.maxProfit(2, prices2));
    }
}
