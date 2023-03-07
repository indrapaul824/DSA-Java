package Dynamic_Programming.D3_Subsequences;

// https://leetcode.com/problems/coin-change/
// https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1


import java.util.*;

public class Q7_CoinChange {
    // Leetcode Solution

    // Recursion
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = minCoins(coins, n-1, amount);
        if (ans >= (int)1e9)
            return -1;
        return ans;
    }
    public static int minCoins(int[] coins, int ind, int T) {
        if (ind == 0) {
            if (T % coins[ind] == 0)
                return T / coins[ind];
            return (int)1e9;
        }
        int not_take = minCoins(coins, ind-1, T);
        int take = Integer.MAX_VALUE;
        if (coins[ind] <= T)
            take = 1 + minCoins(coins, ind, T - coins[ind]);

        return Math.min(take, not_take);
    }

    // DP-1: Memoization
    public int coinChange_mem(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int ans = minCoins(coins, n-1, amount, dp);
        if (ans >= (int)1e9)
            return -1;
        return ans;
    }
    public static int minCoins(int[] coins, int ind, int T, int[][] dp) {
        if (dp[ind][T] != -1)
            return dp[ind][T];
        if (ind == 0) {
            if (T % coins[ind] == 0)
                return T / coins[ind];
            return (int)1e9;
        }
        int not_take = minCoins(coins, ind-1, T, dp);
        int take = Integer.MAX_VALUE;
        if (coins[ind] <= T)
            take = 1 + minCoins(coins, ind, T - coins[ind], dp);

        return dp[ind][T] = Math.min(take, not_take);
    }

    // DP-2: Tabulation
    public int coinChange_tab(int[] coins, int T) {
        int n = coins.length;
        int[][] dp = new int[n][T+1];
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int)1e9;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= T; j++) {
                int not_take = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j && (j - coins[i]) >= 0)
                    take = 1 + dp[i][j-coins[i]];

                dp[i][j] = Math.min(take, not_take);
            }
        }
        if (dp[n-1][T] == (int)1e9)
            return -1;
        return dp[n-1][T];
    }

    // DP-3: Space Optimisation
    public int coinChange_so(int[] coins, int T) {
        int n = coins.length;
        int[] dp = new int[T+1];
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                dp[i] = i / coins[0];
            else
                dp[i] = (int)1e9;
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[T+1];
            for (int j = 1; j <= T; j++) {
                int not_take = dp[j];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j && (j - coins[i]) >= 0)
                    take = 1 + curr[j-coins[i]];

                curr[j] = Math.min(take, not_take);
            }
            dp = curr;
        }
        if (dp[T] == (int)1e9)
            return -1;
        return dp[T];
    }


    // GFG Solution - Greedy
    // Start from the largest denomination
    // If curr denomination is > Target Sum --> Move to next denom
    // If not --> Add it to coins --> Reduce the Target Sum --> Don't move to next denom
    static List<Integer> minPartition(int N) {
        int[] den = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n = den.length - 1;
        List<Integer> coins = new ArrayList<>();

        while (n >= 0) {
            if (den[n] > N)
                n--;
            else {
                coins.add(den[n]);
                N -= den[n];
            }
        }

        return coins;
    }
}
