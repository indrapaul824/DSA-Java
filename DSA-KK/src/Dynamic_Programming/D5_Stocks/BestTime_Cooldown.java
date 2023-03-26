package Dynamic_Programming.D5_Stocks;

// Similar to BestTime_II with a very small modification

import java.util.*;

public class BestTime_Cooldown {
    // Recursion
    public static int maxProfit(int[] prices) {
        return bestTime(0, 1, prices);
    }
    private static int bestTime(int ind, int buy, int[] prices) {
        if (ind >= prices.length)
            return 0;

        if (buy == 1)
            return Math.max(bestTime(ind+1, 0, prices) - prices[ind],
                                bestTime(ind+1, 1, prices));
        return Math.max(bestTime(ind+2, 1, prices) + prices[ind],
                                bestTime(ind+1, 0, prices));
    }

    // DP-1: Memoization
    public static int maxProfit_mem(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return bestTime(0, 1, prices, dp);
    }
    private static int bestTime(int ind, int buy, int[] prices, int[][] dp) {
        if (ind >= prices.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        if (buy == 1)
            return dp[ind][buy] = Math.max(bestTime(ind+1, 0, prices, dp) - prices[ind],
                                bestTime(ind+1, 1, prices, dp));
        return dp[ind][buy] = Math.max(bestTime(ind+2, 1, prices, dp) + prices[ind],
                                bestTime(ind+1, 0, prices, dp));
    }

    // DP-2: Tabulation
    public static int maxProfit_tab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for (int i = n-1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i+1][0] - prices[i], dp[i+1][1]);
            dp[i][0] = Math.max(dp[i+2][1] + prices[i], dp[i+1][0]);
        }
        return dp[0][1];
    }

    // DP-3: Space Optimization
    public int maxProfit_so(int[] prices) {
        int n = prices.length;
        int[] dp2 = new int[2];
        int[] dp1 = new int[2];

        for (int i = n-1; i >= 0; i--) {
            int[] curr = new int[2];
            curr[1] = Math.max(dp1[0] - prices[i], dp1[1]);
            curr[0] = Math.max(dp2[1] + prices[i], dp1[0]);
            dp2 = dp1;
            dp1 = curr;
        }
        return dp1[1];
    }
}
