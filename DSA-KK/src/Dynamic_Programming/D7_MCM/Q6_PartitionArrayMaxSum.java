package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q6_PartitionArrayMaxSum {
    // Recursion
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSum(0, k, arr);
    }

    public int maxSum(int i, int k, int[] arr) {
        if (i == arr.length)
            return 0;

        int len = 0, max = Integer.MIN_VALUE, maxS = max;

        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = len*max + maxSum(j+1, k, arr);
            maxS = Math.max(sum, maxS);
        }

        return maxS;
    }

    // DP-1: Memoization
    public int maxSumAfterPartitioning_mem(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(0, k, arr, dp);
    }

    public int maxSum(int i, int k, int[] arr, int[] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int len = 0, max = Integer.MIN_VALUE, maxS = max;

        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = len*max + maxSum(j+1, k, arr, dp);
            maxS = Math.max(sum, maxS);
        }

        return dp[i] = maxS;
    }

    // DP-2: Tabulation
    public int maxSumAfterPartitioning_tab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];

        for (int i = n-1; i >= 0; i--) {
            int len = 0, max = Integer.MIN_VALUE, maxS = max;

            for (int j = i; j < Math.min(i + k, arr.length); j++) {
                len++;
                max = Math.max(max, arr[j]);
                int sum = len*max + dp[j+1];
                maxS = Math.max(sum, maxS);
            }

            dp[i] = maxS;
        }

        return dp[0];
    }
}
