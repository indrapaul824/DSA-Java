package Dynamic_Programming.D3_Subsequences;

// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

import java.util.Arrays;

public class Q11_RodCutting {

    // Recursion
    public int cutRod(int[] price, int n) {
        return maxPrice(price, n-1, n);
    }
    private int maxPrice(int[] price, int i, int n) {
        // Base
        if (i == 0) {
            return n * price[i];
        }
        int not_pick = maxPrice(price, i-1, n);
        int pick = (int)-1e9;
        if (i + 1 <= n)
            pick = price[i] + maxPrice(price, i, n - i - 1);

        return Math.max(pick, not_pick);
    }

    // DP-1: Memoization
    public int cutRod_mem(int[] price, int n) {
        int[][] dp = new int[n][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxPrice(price, n-1, n, dp);
    }
    private int maxPrice(int[] price, int i, int n, int[][] dp) {
        if (dp[i][n] != -1)
            return dp[i][n];
        // Base
        if (i == 0) {
            return n * price[i];
        }
        int not_pick = maxPrice(price, i-1, n, dp);
        int pick = (int)-1e9;
        if (i + 1 <= n)
            pick = price[i] + maxPrice(price, i, n - i - 1, dp);

        return dp[i][n] = Math.max(pick, not_pick);
    }

    // DP-2: Tabulation
    public int cutRod_tab(int[] price, int n) {
        int[][] dp = new int[n][n+1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int not_pick = dp[i-1][j];
                int pick = (int)-1e9;
                if (i+1 <= j)
                    pick = price[i] + dp[i][j-i-1];
                dp[i][j] = Math.max(pick, not_pick);
            }
        }
        return dp[n-1][n];
    }

    // DP-3: Space Optimisation
    // 1: 2D -> 2 1Ds [dp and curr]
    public static int cutRod_so1(int[] price, int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++)
            dp[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n+1];
            for (int j = 0; j <= n; j++) {
                int not_pick = dp[j];
                int pick = (int)-1e7;
                if (i+1 <= j)
                    pick = price[i] + curr[j - i - 1];

                curr[j] = Math.max(pick, not_pick);
            }
            dp = curr;
        }
        return dp[n];
    }

    // 1: 2D -> 1 1D [only dp]
    public static int cutRod_so2(int[] price, int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++)
            dp[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int not_pick = dp[j];
                int pick = (int)-1e7;
                if (i+1 <= j)
                    pick = price[i] + dp[j - i - 1];

                dp[j] = Math.max(pick, not_pick);
            }
        }
        return dp[n];
    }
}
