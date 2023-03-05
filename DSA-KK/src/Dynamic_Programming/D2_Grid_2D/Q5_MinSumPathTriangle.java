package Dynamic_Programming.D2_Grid_2D;

import java.util.*;

public class Q5_MinSumPathTriangle {

    // Recursive Way
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() - 1;
        return minTri(triangle, 0, 0);
    }
    private int minTri(List<List<Integer>> triangle, int n, int m) {
        if (n == triangle.size()-1)
            return triangle.get(triangle.size()-1).get(m);
        int d = triangle.get(n).get(m) + minTri(triangle, n+1, m);
        int dg = triangle.get(n).get(m) + minTri(triangle, n+1, m+1);

        return Math.min(d, dg);
    }

    // DP-1: Memoization
    public int minimumTotal_mem(List<List<Integer>> triangle) {
        int n = triangle.size() - 1;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return minTri(triangle, 0, 0, dp);
    }
    private int minTri(List<List<Integer>> triangle, int n, int m, int[][] dp) {
        if (n == triangle.size()-1)
            return triangle.get(triangle.size()-1).get(m);
        if (dp[n][m] != -1)
            return dp[n][m];
        int d = triangle.get(n).get(m) + minTri(triangle, n+1, m, dp);
        int dg = triangle.get(n).get(m) + minTri(triangle, n+1, m+1, dp);

        return dp[n][m] = Math.min(d, dg);
    }

    // DP-2: Tabulation
    public int minimumTotal_tab(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++)
            dp[n-1][j] = triangle.get(n-1).get(j);
        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(d, dg);
            }
        }
        return dp[0][0];
    }
}
