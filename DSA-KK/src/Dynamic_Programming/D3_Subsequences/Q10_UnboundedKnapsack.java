package Dynamic_Programming.D3_Subsequences;

// https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

import java.util.Arrays;

public class Q10_UnboundedKnapsack {
    // Recursion
    static int knapSack(int n, int W, int[] val, int[] wt) {
        return knapsack(wt, val, W, n-1);
    }
    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (n==0)
            return (int) (W / wt[0]) * val[0];

        int not_pick = knapsack(wt, val, W, n-1);
        int pick = (int)-1e7;
        if (wt[n] <= W)
            pick = val[n] + knapsack(wt, val, W - wt[n], n);

        return Math.max(pick, not_pick);
    }

    // DP-1: Memoization
    private static int knapSack_mem(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return knapsack(dp, wt, val, W, n-1);
    }
    private static int knapsack(int[][] dp, int[] wt, int[] val, int W, int n) {
        if (dp[n][W] != -1)
            return dp[n][W];
        if (n==0) {
            return (int) (W / wt[0]) * val[0];
        }
        int not_pick = knapsack(dp, wt, val, W, n-1);
        int pick = (int)-1e7;
        if (wt[n] <= W)
            pick = val[n] + knapsack(dp, wt, val, W - wt[n], n);

        return dp[n][W] = Math.max(pick, not_pick);
    }

    // DP-2: Tabulation
    public static int knapSack_tab(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W+1];
        for (int j = wt[0]; j <= W; j++)
            dp[0][j] = (int) (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int not_pick = dp[i-1][j];
                int pick = (int)-1e7;
                if (wt[i] <= W && j - wt[i] >= 0)
                    pick = val[i] + dp[i][j - wt[i]];

                dp[i][j] = Math.max(pick, not_pick);
            }
        }
        return dp[n-1][W];
    }

    // DP-3: Space Optimisation
    // 1: 2D -> 2 1Ds [dp and curr]
    public static int knapSack_so1(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W+1];
        for (int j = wt[0]; j <= W; j++)
            dp[j] = (int) (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W+1];
            for (int j = 0; j <= W; j++) {
                int not_pick = dp[j];
                int pick = (int)-1e7;
                if (wt[i] <= W && j - wt[i] >= 0)
                    pick = val[i] + curr[j - wt[i]];

                curr[j] = Math.max(pick, not_pick);
            }
            dp = curr;
        }
        return dp[W];
    }

    // 1: 2D -> 1 1D [only dp]
    public static int knapSack_so2(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W+1];
        for (int j = wt[0]; j <= W; j++)
            dp[j] = (int) (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int not_pick = dp[j];
                int pick = (int)-1e7;
                if (wt[i] <= W && j - wt[i] >= 0)
                    pick = val[i] + dp[j - wt[i]];

                dp[j] = Math.max(pick, not_pick);
            }
        }
        return dp[W];
    }
}
