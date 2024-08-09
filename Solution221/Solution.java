public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSideLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    maxSideLength = Math.max(maxSideLength, dp[i][j]);
                }
            }
        }

        return maxSideLength * maxSideLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(sol.maximalSquare(matrix1));

        char[][] matrix2 = {
            {'0', '1'},
            {'1', '0'}
        };
        System.out.println(sol.maximalSquare(matrix2));

        char[][] matrix3 = {
            {'0'}
        };
        System.out.println(sol.maximalSquare(matrix3));
    }
}
