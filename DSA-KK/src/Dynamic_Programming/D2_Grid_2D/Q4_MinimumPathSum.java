package Dynamic_Programming.D2_Grid_2D;

import java.util.*;

public class Q4_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3}, {1,5}};
        System.out.println(minPathSum(grid));
    }

    // Recursive Way
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return (int)minPath(grid, m-1, n-1);
    }
    public static long minPath(int[][] grid, int m, int n) {
        if (m == 0 && n == 0)
            return grid[0][0];
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        long up = grid[m][n] + minPath(grid, m-1, n);
        long left = grid[m][n] + minPath(grid, m, n-1);

        return Math.min(up, left);
    }

    // DP-1: Memoization
    public static int minPathSum_mem(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return (int)minPath(grid, m-1, n-1, dp);
    }
    public static long minPath(int[][] grid, int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return grid[0][0];
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (dp[m][n] != -1)
            return dp[m][n];

        long up = grid[m][n] + minPath(grid, m-1, n, dp);
        long left = grid[m][n] + minPath(grid, m, n-1, dp);

        return Math.min(up, left);
    }

    // DP-2: Tabulation
    public static int minPathSum_tab(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    long left = grid[i][j], up = grid[i][j];
                    if (j > 0)
                        left += dp[i][j-1];
                    else
                        left += 1e9;
                    if (i > 0)
                        up += dp[i-1][j];
                    else
                        up += 1e9;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return (int)dp[m-1][n-1];
    }

    // DP-3: Space Optimization
    public static int minPathSum_so(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] dp = new long[n];

        for (int i = 0; i < m; i++) {
            long[] curr = new long[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    curr[j] = grid[i][j];
                else {
                    long left = grid[i][j], up = grid[i][j];
                    if (j > 0)
                        left += curr[j-1];
                    else
                        left += 1e9;
                    if (i > 0)
                        up += dp[j];
                    else
                        up += 1e9;
                    curr[j] = Math.min(up, left);
                }
            }
            dp = curr;
        }

        return (int)dp[n-1];
    }
}
