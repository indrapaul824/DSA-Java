package Dynamic_Programming.OneDim;

import utils.Main.*;
import java.util.*;

public class Q4_MaxNonAdSum {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(findMaxSum(arr, n));
        System.out.println(findMaxSum_mem(arr, n));
        System.out.println(findMaxSum_tab(arr, n));
        System.out.println(findMaxSum_so(arr, n));
    }

    // Recursive Way
    private static int findMaxSum(int[] arr, int n) {
        return maxSumSub(arr, n-1);
    }

    private static int maxSumSub(int[] arr, int ind) {
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;
        int pick = arr[ind] + maxSumSub(arr, ind - 2);
        int not_pick = maxSumSub(arr, ind - 1);

        return Math.max(pick, not_pick);
    }

    // DP-1: Memoization
    private static int findMaxSum_mem(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSumSub(arr, n-1, dp);
    }
    private static int maxSumSub(int[] arr, int ind, int[] dp) {
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pick = arr[ind] + maxSumSub(arr, ind - 2, dp);
        int not_pick = maxSumSub(arr, ind - 1, dp);

        return dp[ind] = Math.max(pick, not_pick);
    }

    // DP-2: Tabulation
    private static int findMaxSum_tab(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int not_pick = dp[i - 1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n-1];
    }

    // DP-3: Space Optimization
    private static int findMaxSum_so(int[] arr, int n) {
        int prev2 = 0, prev = arr[0], curr;
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int not_pick = prev;
            curr = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
