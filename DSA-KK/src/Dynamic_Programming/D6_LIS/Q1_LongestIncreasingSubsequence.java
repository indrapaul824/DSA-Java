package Dynamic_Programming.D6_LIS;

import java.util.Arrays;

public class Q1_LongestIncreasingSubsequence {

    // Recursion
    public int lengthOfLIS(int[] nums) {
        return LIS(0, -1, nums);
    }

    private int LIS(int ind, int prev, int[] nums) {
        // Base Case
        if (ind == nums.length)
            return 0;

        // Not take
        int len = LIS(ind+1, prev, nums);

        // Take
        if (prev == -1 || nums[ind] > nums[prev])
            len = Math.max(len, 1 + LIS(ind+1, ind, nums));

        return len;
    }

    // DP-1: Memoization
    public int lengthOfLIS_mem(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return LIS(0, -1, nums, dp);
    }

    private int LIS(int ind, int prev, int[] nums, int[][] dp) {
        // Base Case
        if (ind == nums.length)
            return 0;

        if (dp[ind][prev+1] != -1)
            return dp[ind][prev+1];

        // Not take
        int len = LIS(ind+1, prev, nums, dp);

        // Take
        if (prev == -1 || nums[ind] > nums[prev])
            len = Math.max(len, 1 + LIS(ind+1, ind, nums, dp));

        return dp[ind][prev+1] = len;
    }

    // DP-2: Tabulation
    public int lengthOfLIS_tab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i-1; j >= -1; j--) {
                // Not take
                int len = dp[i+1][j+1];

                // Take
                if (j == -1 || nums[i] > nums[j])
                    len = Math.max(len, 1 + dp[i+1][i+1]);
                dp[i][j+1] = len;
            }
        }

        return dp[0][-1+1];
    }

    // DP-3: Space Optimization
    public int lengthOfLIS_so(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        for (int i = n-1; i >= 0; i--) {
            int[] curr = new int[n+1];
            for (int j = i-1; j >= -1; j--) {
                // Not take
                int len = dp[j+1];

                // Take
                if (j == -1 || nums[i] > nums[j])
                    len = Math.max(len, 1 + dp[i+1]);
                curr[j+1] = len;
            }
            dp = curr;
        }

        return dp[-1+1];
    }

    // DP-4: Optimized Non-Intuitive Tabulation
    public int lengthOfLIS_tab2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (nums[ind] > nums[prev])
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
            }
            max = Math.max(dp[ind], max);
        }

        return max;
    }
}
