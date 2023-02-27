package Dynamic_Programming.OneDim;

import utils.Main.*;
import java.util.Arrays;

public class Q1_ClimbingStairs {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairs(n));
        System.out.println(climbStairs_mem(n, dp));
        System.out.println(climbStairs_tab(n));
        System.out.println(climbStairs_so(n));
    }

    // Recursive Way
    private static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // DP-1: Memoization
    private static int climbStairs_mem(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairs_mem(n - 1, dp) + climbStairs_mem(n - 2, dp);
    }

    // DP-2: Tabular
    private static int climbStairs_tab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // DP-3: Space-Optimized
    private static int climbStairs_so(int n) {
        int s_0 = 1, s_1 = 1, s_n;

        for (int i = 2; i <= n; i++) {
            s_n = s_0 + s_1;
            s_0 = s_1;
            s_1 = s_n;
        }

        return s_1;
    }
}
