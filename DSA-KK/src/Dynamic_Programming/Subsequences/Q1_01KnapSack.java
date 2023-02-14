package Dynamic_Programming.Subsequences;

import utils.Main.*;
import java.util.*;

public class Q1_01KnapSack {
    static int[][] dp = new int[1002][1002];
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = 3;
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int W = 4;
        System.out.println(knapsack(wt, val, W, n));

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println(knapsack_mem(wt, val, W, n));
    }

    // Recursion
    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (n==0 || W == 0)
            return 0;
        if (wt[n-1] <= W)
            return Math.max(val[n-1] + knapsack(wt, val, W - wt[n-1], n-1),
                            knapsack(wt, val, W, n-1));
        else
            return knapsack(wt, val, W, n-1);
    }

    // DP1: Memoization
    private static int knapsack_mem(int[] wt, int[] val, int W, int n) {
        if (n==0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        if (wt[n-1] <= W)
            return dp[n][W] = Math.max(val[n-1] + knapsack_mem(wt, val, W - wt[n-1], n-1),
                            knapsack_mem(wt, val, W, n-1));
        else
            return dp[n][W] = knapsack_mem(wt, val, W, n-1);
    }

    // DP2: Tabulation
//    private static int knapsack_tab(int[] wt, int[] val, int W, int n) {
//        int[][] dp = new int[n+1][W+1];
//        dp[0][0] = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < W; j++) {
//                break;
//            }
//        }
//    }
}
