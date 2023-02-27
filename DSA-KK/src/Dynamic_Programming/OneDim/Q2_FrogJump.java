package Dynamic_Programming.OneDim;

import static java.lang.Math.*;
import utils.Main.*;
import java.util.*;

public class Q2_FrogJump {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(minEnergy(arr, n));
        System.out.println(minEnergy_mem(arr, n));
        System.out.println(minEnergy_tab(arr, n));
        System.out.println(minEnergy_so(arr, n));
    }

    // Recursive Way
    private static int minEnergy(int[] arr, int n) {
        return frogJump(arr, n-1);
    }
    private static int frogJump(int[] arr, int ind) {
        if (ind == 0)
            return 0;
        int left = frogJump(arr, ind - 1) + abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = frogJump(arr, ind - 2) + abs(arr[ind] - arr[ind - 2]);

        return min(left, right);
    }

    // DP-1: Memoization
    private static int minEnergy_mem(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(arr, n-1, dp);
    }
    private static int frogJump(int[] arr, int ind, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int left = frogJump(arr, ind - 1, dp) + abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = frogJump(arr, ind - 2, dp) + abs(arr[ind] - arr[ind - 2]);

        return dp[ind] = min(left, right);
    }

    // DP-2: Tabulation
    private static int minEnergy_tab(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = dp[i - 2] + abs(arr[i] - arr[i - 2]);

            dp[i] = min(left, right);
        }
        return dp[n-1];
    }

    // DP-3: Space Optimization
    private static int minEnergy_so(int[] arr, int n) {
        int prev2 = 0, prev1 = 0, curr;
        for (int i = 1; i < n; i++) {
            int left = prev1 + abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + abs(arr[i] - arr[i - 2]);

            curr = min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
