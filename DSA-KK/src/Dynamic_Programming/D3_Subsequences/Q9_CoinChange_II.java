package Dynamic_Programming.D3_Subsequences;

// https://leetcode.com/problems/coin-change-ii/
// https://practice.geeksforgeeks.org/problems/coin-change2448/1

import java.util.Arrays;

public class Q9_CoinChange_II {
    public int change(int amount, int[] coins) {
        return countCoins(coins, coins.length-1, amount);
    }

    private static int countCoins(int[] coins, int ind, int target) {
        if (ind == 0) {
            if (target % coins[ind] == 0)
                return 1;
            else
                return 0;
        }

        int not_take = countCoins(coins, ind-1, target);
        int take = 0;
        if (coins[ind] <= target)
            take = countCoins(coins, ind, target - coins[ind]);

        return take + not_take;
    }

    // DP-1: Memoization
    public int change_mem(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return countCoins(coins, coins.length-1, amount, dp);
    }

    private static int countCoins(int[] coins, int ind, int target, int[][] dp) {
        if (dp[ind][target] != -1)
            return dp[ind][target];
        if (ind == 0) {
            if (target % coins[0] == 0)
                return 1;
            else
                return 0;
        }

        int not_take = countCoins(coins, ind-1, target, dp);
        int take = 0;
        if (coins[ind] <= target)
            take = countCoins(coins, ind, target - coins[ind], dp);

        return dp[ind][target] = take + not_take;
    }

    // DP-2: Tabulation
    public int change_tab(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        int n = coins.length;

        for (int j = 0; j <= amount; j++)
            dp[0][j] = (j % coins[0] == 0) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[i-1][j];
                int take = 0;
                if (coins[i] <= j )
                    take = dp[i][j - coins[i]];

                dp[i][j] = take + not_take;
            }
        }

        return dp[n-1][amount];
    }

    // DP-3: Space Optimization
    public int change_so(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        int n = coins.length;

        for (int j = 0; j <= amount; j++)
            dp[j] = (j % coins[0] == 0) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[j];
                int take = 0;
                if (coins[i] <= j )
                    take = curr[j - coins[i]];

                curr[j] = take + not_take;
            }
            dp = curr;
        }

        return dp[amount];
    }
}
