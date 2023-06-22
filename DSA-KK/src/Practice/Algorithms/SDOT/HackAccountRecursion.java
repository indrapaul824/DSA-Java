package Practice.Algorithms.SDOT;
import utils.Main.*;

import java.util.Arrays;

public class HackAccountRecursion {
    private static boolean hack(int n) {
        if (n == 1)
            return true;
        if (n < 1)
            return false;
        return (hack(n / 10) || hack(n / 20));
    }

    private static boolean hack_mem(int n, int[] dp) {
        if (n == 1)
            return true;
        if (n < 1)
            return false;
        if (dp[n] != -1)
            return dp[n] == 1;
        boolean h = (hack_mem(n / 10, dp) || hack_mem(n / 20, dp));
        dp[n] = (h) ? 1 : 0;
        return h;
    }

    private static boolean hack_tab(int n) {
        boolean[] dp = new boolean[n+1];
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i/10] || dp[i/20];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(hack(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(hack_mem(n, dp));

        System.out.println(hack_tab(n));
    }
}
