package Dynamic_Programming.D5_Stocks;

import java.util.Arrays;

public class BestTime_III {

    // Recursion
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        return bestTime(0, 1, 2, prices);
    }
    private static int bestTime(int ind, int buy, int cap, int[] prices) {
        if (cap == 0 || ind == prices.length)
            return 0;

        if (buy == 1)
            return Math.max(bestTime(ind+1, 0, cap, prices) - prices[ind],
                    bestTime(ind+1, 1, cap, prices));
        return Math.max(bestTime(ind+1, 1, cap-1, prices) + prices[ind],
                bestTime(ind+1, 0, cap, prices));
    }

    // DP-1: Memoization
    public static int maxProfit_mem(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        Arrays.stream(dp).forEach(a -> Arrays.stream(a).forEach(b -> Arrays.fill(b, -1)));
        return bestTime(0, 1, 2, prices, dp);
    }

    private static int bestTime(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0 || ind == prices.length)
            return dp[ind][buy][cap] = 0;

        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        if (buy == 1)
            return dp[ind][buy][cap] = Math.max(bestTime(ind+1, 0, cap, prices, dp) - prices[ind],
                            bestTime(ind+1, 1, cap, prices, dp));
        return dp[ind][buy][cap] = Math.max(bestTime(ind+1, 1, cap-1, prices, dp) + prices[ind],
                            bestTime(ind+1, 0, cap, prices, dp));
    }

    // DP-2: Tabulation
    public static int maxProfit_tab(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n-1; i >= 0; i--) {
            for (int cap = 1; cap < 3; cap++) {
                dp[i][1][cap] = Math.max(dp[i+1][0][cap] - prices[i], dp[i+1][1][cap]);
                dp[i][0][cap] = Math.max(dp[i+1][1][cap-1] + prices[i], dp[i+1][0][cap]);
            }
        }

        return dp[0][1][2];
    }

    // DP-3: Space Optimzation
    public static int maxProfit_so(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];

        for (int i = n-1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for (int cap = 1; cap < 3; cap++) {
                curr[1][cap] = Math.max(dp[0][cap] - prices[i], dp[1][cap]);
                curr[0][cap] = Math.max(dp[1][cap-1] + prices[i], dp[0][cap]);
            }
            dp = curr;
        }

        return dp[1][2];
    }
}
