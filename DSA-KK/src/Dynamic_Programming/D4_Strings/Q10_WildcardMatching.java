package Dynamic_Programming.D4_Strings;

import java.util.*;

public class Q10_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        return wildcardMatch(n-1, m-1, s, p);
    }

    private boolean wildcardMatch(int i, int j, String s, String p) {
        // Base Case
        // When Pattern gets exhausted
        if (j < 0 && i < 0) return true;
        if (j < 0 && i >= 0) return false;

        // When String gets exhausted and Pattern is left
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        // String Matching
        // If char matches, or we get a '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return wildcardMatch(i-1, j-1, s, p);

        // If we get a '*'
        if (p.charAt(j) == '*')
            return (wildcardMatch(i-1, j, s, p) || wildcardMatch(i, j-1, s, p));

        // If no matches found
        return false;
    }

    // DP-1: Memoization
    public boolean isMatch_mem(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return wildcardMatch(n - 1, m - 1, s, p, dp) == 1;
    }

    private int wildcardMatch(int i, int j, String s, String p, int[][] dp) {
        // Base Case
        // When Pattern gets exhausted
        if (j < 0 && i < 0) return 1;
        if (j < 0 && i >= 0) return 0;

        // When String gets exhausted and Pattern is left
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        // String Matching
        // If char matches, or we get a '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = wildcardMatch(i-1, j-1, s, p, dp);

        // If we get a '*'
        if (p.charAt(j) == '*')
            return dp[i][j] = (wildcardMatch(i-1, j, s, p, dp) == 1
                    || wildcardMatch(i, j-1, s, p, dp) == 1) ? 1 : 0;

        // If no matches found
        return dp[i][j] = 0;
    }

    // DP-2: Tabulation
    public boolean isMatch_tab(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            dp[i][0] = false;
        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }

    // DP-3: Space Optimization
    public boolean isMatch_so(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] dp = new boolean[m+1];

        dp[0] = true;

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m+1];
            // For dp[i][0] = false;
            curr[0] = false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    curr[j] = dp[j-1];
                else if (p.charAt(j-1) == '*')
                    curr[j] = dp[j] || curr[j-1];
                else
                    curr[j] = false;
            }
            dp = curr;
        }
        return dp[m];
    }
}
