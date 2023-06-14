package Day3_Arrays_III;
import java.util.*;

public class Q5_GridUniquePaths {

    // Brute: Recursion
    private int solve(int i, int j) {
        if (i == 0 && j == 0)
            return 1;

        if (i < 0 || j < 0)
            return 0;

        int left = solve(i, j-1);
        int up = solve(i-1, j);

        return left + up;
    }
    public int uniquePaths_mem(int m, int n) {
        return solve(m-1, n-1);
    }

    // Better: Memoization
    private int solve(int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int left = solve(i, j-1, dp);
        int up = solve(i-1, j, dp);

        return dp[i][j] = left + up;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solve(m-1, n-1, dp);
    }

    // Better: Tabulation
    public int uniquePaths_tab(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    // Better: Space Optimization
    public int uniquePaths_so(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    curr[j] = 1;
                else {
                    curr[j] = curr[j - 1] + dp[j];
                }
            }
            dp = curr;
        }

        return dp[n - 1];
    }

    // Optimal
}
