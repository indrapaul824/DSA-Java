package Dynamic_Programming.D5_Stocks;

// Same as BestTime_II with a very slight modification

import java.util.*;

public class BestTime_TransFee {
    // Recursion
    public static int maxProfit(int[] prices, int fee) {
        return bestTime(0, 1, fee, prices);
    }

    private static int bestTime(int ind, int buy, int fee, int[] prices) {
        if (ind == prices.length)
            return 0;

        if (buy == 1)
            return Math.max(bestTime(ind+1, 0, fee, prices) - prices[ind],
                                bestTime(ind+1, 1, fee, prices));
        return Math.max(bestTime(ind+1, 1, fee, prices) + prices[ind] - fee,
                                bestTime(ind+1, 0, fee, prices));
    }

    // DP-1: Memoization
    public static int maxProfit_mem(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return bestTime(0, 1, prices, fee, dp);
    }
    private static int bestTime(int ind, int buy, int[] prices, int fee, int[][] dp) {
        if (ind == prices.length)
            return dp[ind][buy] = 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        if (buy == 1)
            return dp[ind][buy] = Math.max(bestTime(ind+1, 0, prices, fee, dp) - prices[ind],
                                bestTime(ind+1, 1, prices, fee, dp));
        return dp[ind][buy] = Math.max(bestTime(ind+1, 1, prices, fee, dp) + prices[ind] - fee,
                                bestTime(ind+1, 0, prices, fee, dp));
    }

    // DP-2: Tabulation
    public static int maxProfit_tab(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n-1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i+1][0] - prices[i], dp[i+1][1]);
            dp[i][0] = Math.max(dp[i+1][1] + prices[i] - fee, dp[i+1][0]);
        }
        return dp[0][1];
    }

    // DP-3: Space Optimization
    public int maxProfit_so(int[] prices, int fee) {
        int n = prices.length;
        int aheadNotBuy = 0, aheadBuy = 0;

        for (int i = n-1; i >= 0; i--) {
            int currBuy = Math.max(aheadNotBuy - prices[i], aheadBuy);
            int currNotBuy = Math.max(aheadBuy + prices[i] - fee, aheadNotBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
