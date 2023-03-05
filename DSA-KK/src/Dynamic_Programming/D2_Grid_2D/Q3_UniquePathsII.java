package Dynamic_Programming.D2_Grid_2D;

// https://leetcode.com/problems/unique-paths-ii/

import java.util.Arrays;

public class Q3_UniquePathsII {

    // Recursive Way
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return grid(obstacleGrid, m-1, n-1);
    }
    public static int grid(int[][] obstacleGrid, int m, int n) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;

        int up = grid(obstacleGrid, m-1, n);
        int left = grid(obstacleGrid, m, n-1);

        return up+left;
    }

    // DP-1: Memoization
    public static int uniquePathsWithObstacles_mem(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return grid(obstacleGrid, m-1, n-1, dp);
    }
    public static int grid(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        int up = grid(obstacleGrid, m-1, n, dp);
        int left = grid(obstacleGrid, m, n-1, dp);

        return dp[m][n] = up+left;
    }

    // DP-2: Tabulation
    public int uniquePathsWithObstacles_tab(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i == 0 && j == 0)
                    dp[0][0] = 1;
                else {
                    int left = 0, up = 0;
                    if (i > 0)
                        up = dp[i-1][j];
                    if (j > 0)
                        left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    // DP-3: Space Optimization
    public int uniquePathsWithObstacles_so(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    curr[j] = 0;
                else if (i == 0 && j == 0)
                    curr[j] = 1;
                else {
                    int left = 0, up = dp[j];
                    if (j > 0)
                        left = curr[j-1];
                    curr[j] = up + left;
                }
            }
            dp = curr;
        }
        return dp[n-1];
    }
}
