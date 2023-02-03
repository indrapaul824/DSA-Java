package Dynamic_Programming;

import utils.Main.*;
import java.util.*;

// Using Fibonacci number Problem and its recursive solution

public class D1_Intro {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(fibo_rec(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibo_mem(n, dp));
        System.out.println(fibo_tab(n));
        System.out.println(fibo_so(n));
        System.out.println(fibo_sol(n));
    }

    // Recursive Way
    private static int fibo_rec(int n) {
        if (n <= 1)
            return n;
        return fibo_rec(n - 1) + fibo_rec(n - 2);
    }

    // DP-1: Memoization
    private static int fibo_mem(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibo_mem(n - 1, dp) + fibo_mem(n - 2, dp);
    }

    // DP-2: Tabular
    private static int fibo_tab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // DP-3: Space-Optimized
    private static int fibo_so(int n) {
        int prev2 = 0, prev = 1, curr_i;
        for (int i = 2; i <= n; i++) {
            curr_i = prev + prev2;
            prev2 = prev;
            prev = curr_i;
        }
        return prev;
    }

    // Using long data type for larger values
    private static long fibo_sol(int n) {
        long mod = (long) (1e9) + 7;
        long prev2 = 0, prev = 1, curr_i;
        for (int i = 2; i <= n; i++) {
            curr_i = (prev + prev2) % mod;
            prev2 = prev;
            prev = curr_i;
        }
        return prev%mod;
    }
}
