package Dynamic_Programming.D2_Grid_2D;

// https://leetcode.com/problems/minimum-falling-path-sum/

import java.util.*;

public class Q6_MinFallingPathSum {

    // Recursive Way
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min_i = 10000;
        for (int i = 0; i < n; i++)
            min_i = Math.min(min_i, minSum(matrix, n-1, i));
        return min_i;
    }

    private int minSum(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix.length)
            return 10000;
        if (i == 0)
            return matrix[0][j];

        int up = matrix[i][j] + minSum(matrix, i-1, j);
        int left = matrix[i][j] + minSum(matrix, i-1, j-1);
        int right = matrix[i][j] + minSum(matrix, i-1, j+1);

        return Math.min(up, Math.min(left, right));
    }

    // DP-1: Memoization
    public int minFallingPathSum_mem(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minSum(matrix, 0, 0, dp);
    }
    private int minSum(int[][] matrix, int i, int j, int[][] dp) {
        return 0;
    }

    // DP-2: Tabulation
    public int minFallingPathSum_tab(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = matrix[i][j], right = matrix[i][j];
                int up = matrix[i][j] + dp[i-1][j];
                if (j-1 >= 0)
                    left += dp[i-1][j-1];
                else
                    left += 1e8;
                if (j+1 < n)
                    right += dp[i-1][j+1];
                else
                    right += 1e8;
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int min_i = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            min_i = Math.min(min_i, dp[n-1][i]);
        }
        return min_i;
    }

    // DP-3: Space Optimization
    public int minFallingPathSum_so(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        System.arraycopy(matrix[0], 0, dp, 0, n);
        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int left = matrix[i][j], right = matrix[i][j];
                int up = matrix[i][j] + dp[j];
                if (j-1 >= 0)
                    left += dp[j-1];
                else
                    left += 1e8;
                if (j+1 < n)
                    right += dp[j+1];
                else
                    right += 1e8;
                curr[j] = Math.min(up, Math.min(left, right));
            }
            dp = curr;
        }
        int min_i = dp[0];
        for (int i = 1; i < n; i++) {
            min_i = Math.min(min_i, dp[i]);
        }
        return min_i;
    }
}
