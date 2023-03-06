package Dynamic_Programming.D2_Grid_2D;

// https://practice.geeksforgeeks.org/problems/chocolates-pickup/1

import java.util.Arrays;

public class Q7_CherryPickup_3D {
    // Recursive Solution
    public int solve(int n, int m, int[][] grid){
        return maxChoco(grid, 0, 0, m-1);
    }

    public int maxChoco(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
            return -100000;
        if (i == grid.length-1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2)
                    maxi = Math.max(maxi, grid[i][j1] + maxChoco(grid, i+1, j1+dj1, j2+dj2));
                else
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + maxChoco(grid, i+1, j1+dj1, j2+dj2));
            }
        }
        return maxi;
    }

    // DP-1: Memoization
    public int solve_mem(int n, int m, int[][] grid){
        int[][][] dp = new int[n][m][m];
        Arrays.stream(dp).forEach(a -> Arrays.stream(a).forEach(d -> Arrays.fill(d, -1)));
        return maxChoco(grid, 0, 0, m-1, dp);
    }

    public int maxChoco(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
            return -100000;
        if (i == grid.length-1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2)
                    maxi = Math.max(maxi, grid[i][j1] + maxChoco(grid, i+1, j1+dj1, j2+dj2, dp));
                else
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + maxChoco(grid, i+1, j1+dj1, j2+dj2, dp));
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    // DP-2:Tabulation
    public int solve_tab(int n, int m, int[][] grid){
        int[][][] dp = new int[n][m][m];

        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n-1][j1][j2] = grid[n-1][j1];
                else
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // Explore all paths
        for (int i = n-2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int val = 0;
                            if (j1 == j2)
                                val =  grid[i][j1];
                            else
                                val = grid[i][j1] + grid[i][j2];
                            if (j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                val += dp[i+1][j1+dj1][j2+dj2];
                            else
                                val += -100000;
                            maxi = Math.max(maxi, val);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }

    // DP-3: Space Optimization
    public int solve_so(int n, int m, int[][] grid){
        int[][] dp = new int[m][m];

        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[j1][j2] = grid[n-1][j1];
                else
                    dp[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // Explore all paths
        for (int i = n-2; i >= 0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int val = 0;
                            if (j1 == j2)
                                val =  grid[i][j1];
                            else
                                val = grid[i][j1] + grid[i][j2];
                            if (j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                val += dp[j1+dj1][j2+dj2];
                            else
                                val += -100000;
                            maxi = Math.max(maxi, val);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            dp = curr;
        }
        return dp[0][m-1];
    }
}
