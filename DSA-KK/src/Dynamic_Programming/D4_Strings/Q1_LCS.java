package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/longest-common-subsequence/
// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

// Longest Common Subsequence

import java.util.Arrays;

public class Q1_LCS {
    // Recursive Solution
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length()-1, text2.length()-1);
    }

    public static int lcs(String S1, String S2, int ind1, int ind2) {
        // Base Case
        if (ind1 < 0 || ind2 < 0)
            return 0;

        // If matched
        if (S1.charAt(ind1) == S2.charAt(ind2))
            return 1 + lcs(S1, S2, ind1 - 1, ind2 - 1);

        // If not matched
        return Math.max(lcs(S1, S2, ind1-1, ind2), lcs(S1, S2, ind1, ind2-1));
    }

    // DP-1: Memoization
    public int longestCommonSubsequence_mem(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return lcs(text1, text2, n-1, m-1, dp);
    }

    public static int lcs(String S1, String S2, int ind1, int ind2, int[][] dp) {
        // Base Case
        if (ind1 < 0 || ind2 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If matched
        if (S1.charAt(ind1) == S2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcs(S1, S2, ind1 - 1, ind2 - 1, dp);

        // If not matched
        return dp[ind1][ind2] = Math.max(lcs(S1, S2, ind1-1, ind2, dp), lcs(S1, S2, ind1, ind2-1, dp));
    }

    // DP-2: Tabulation
    public int longestCommonSubsequence_tab(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // Base Case
        // for (int i = 0; i <= n; i++) dp[i][0] = 0;
        // for (int j = 0; j <= m; i++) dp[0][j] = 0;

        // Bottom-Up Approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }

    // DP-3: Space Optimization
    public int longestCommonSubsequence_so(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] dp = new int[m+1];
        // Base Case
        // for (int i = 0; i <= n; i++) dp[i][0] = 0;
        // for (int j = 0; j <= m; i++) dp[0][j] = 0;

        // Bottom-Up Approach
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    curr[j] = 1 + dp[j-1];
                else
                    curr[j] = Math.max(dp[j], curr[j-1]);
            }
            dp = curr;
        }

        return dp[m];
    }
}
