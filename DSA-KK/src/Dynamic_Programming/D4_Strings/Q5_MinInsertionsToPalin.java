package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1

public class Q5_MinInsertionsToPalin {
    public static int longestPalindromeSubseq(String s) {
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

    public int minInsertions(String s) {
        return (s.length() - longestPalindromeSubseq(s));
    }
}
