package Dynamic_Programming.D5_Stocks;

public class BestTime_IV {
    // from BT_III -> DP-2: Tabulation modified
    public static int maxProfit_tabP(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1];

        for (int i = n-1; i >= 0; i--) {
            for (int cap = 1; cap <= k; cap++) {
                dp[i][1][cap] = Math.max(dp[i+1][0][cap] - prices[i], dp[i+1][1][cap]);
                dp[i][0][cap] = Math.max(dp[i+1][1][cap-1] + prices[i], dp[i+1][0][cap]);
            }
        }

        return dp[0][1][k];
    }

    // from BT_III -> DP-3: Space Optimization modified
    public static int maxProfit_soP(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][k+1];

        for (int i = n-1; i >= 0; i--) {
            int[][] curr = new int[2][k+1];
            for (int cap = 1; cap <= k; cap++) {
                curr[1][cap] = Math.max(dp[0][cap] - prices[i], dp[1][cap]);
                curr[0][cap] = Math.max(dp[1][cap-1] + prices[i], dp[0][cap]);
            }
            dp = curr;
        }

        return dp[1][k];
    }
}
