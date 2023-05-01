package Dynamic_Programming.D8_Squares;
// https://leetcode.com/problems/maximal-square/

public class Q3_MaxAreaSquareBinMatrix {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;

        // Base Case
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(dp[0][j], max);
        }
        // All other cases
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] - '0' == 1)
                    dp[i][j] = Math.min(dp[i-1][j],
                            Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(dp[i][j], max);
            }
        }

        return max*max;
    }
}
