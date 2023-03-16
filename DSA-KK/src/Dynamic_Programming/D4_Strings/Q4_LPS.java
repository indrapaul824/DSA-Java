package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/longest-palindromic-subsequence/
// https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1

// Longest Palindromic Subsequence

public class Q4_LPS {
    // DP-3: Space Optimised
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int m = r.length();
        int[] dp = new int[m+1];

        for (int i = 1; i <= s.length(); i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == r.charAt(j-1)) {
                    curr[j] = 1 + dp[j-1];
                }
                else
                    curr[j] = Math.max(dp[j], curr[j-1]);
            }
            dp = curr;
        }

        return dp[m];
    }


}
