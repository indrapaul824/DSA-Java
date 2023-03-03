package Dynamic_Programming.D1_OneDim;

import static java.lang.Math.*;
import utils.Main.*;
import java.util.*;

public class Q3_FrogJumpKSteps {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(minEnergy(arr, n, k));
        System.out.println(minEnergy_mem(arr, n, k));
        System.out.println(minEnergy_tab(arr, n, k));
    }

    // Recursive Way
    private static int minEnergy(int[] arr, int n, int k) {
        return frogJump(arr, n-1, k);
    }
    private static int frogJump(int[] arr, int ind, int k) {
        if (ind == 0)
            return 0;
        int min_cost = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = frogJump(arr, ind - j, k) +
                        abs(arr[ind] - arr[ind - j]);
                min_cost = min(min_cost, jump);
            }
        }
        return min_cost;
    }

    // DP-1: Memoization
    private static int minEnergy_mem(int[] arr, int n, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(arr, n-1, dp, k);
    }
    private static int frogJump(int[] arr, int ind, int[] dp, int k) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int min_cost = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = frogJump(arr, ind - j, dp, k) +
                        abs(arr[ind] - arr[ind - j]);
                min_cost = min(min_cost, jump);
            }
        }
        return dp[ind] = min_cost;
    }


    // DP-2: Tabulation
    private static int minEnergy_tab(int[] arr, int n, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min_cost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + abs(arr[i] - arr[i - j]);
                    min_cost = min(min_cost, jump);
                }
            }
            dp[i] = min_cost;
        }
        return dp[n-1];
    }
}
