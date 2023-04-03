package Dynamic_Programming.D6_LIS;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

public class Q7_NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 1;
        for (int ind = 0; ind < n; ind++) {
            dp[ind] = 1;
            cnt[ind] = 1;
            for (int prev = 0; prev < ind; prev++) {
                if (nums[ind] > nums[prev]) {
                    if (1 + dp[prev] > dp[ind]) {
                        dp[ind] = 1 + dp[prev];
                        // inherit the count
                        cnt[ind] = cnt[prev];
                    }
                    else if (1 + dp[prev] == dp[ind]) {
                        // increase the count
                        cnt[ind] += cnt[prev];
                    }
                }
            }
            max = Math.max(max, dp[ind]);
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (dp[i] == max) count += cnt[i];
        return count;
    }
}
