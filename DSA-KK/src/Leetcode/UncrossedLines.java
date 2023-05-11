package Leetcode;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] dp = new int[m+1];
        // Base Case
        // for (int i = 0; i <= n; i++) dp[i][0] = 0;
        // for (int j = 0; j <= m; i++) dp[0][j] = 0;

        // Bottom-Up Approach
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1])
                    curr[j] = 1 + dp[j-1];
                else
                    curr[j] = Math.max(dp[j], curr[j-1]);
            }
            dp = curr;
        }

        return dp[m];
    }
}
