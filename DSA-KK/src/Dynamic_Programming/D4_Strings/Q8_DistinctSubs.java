package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/distinct-subsequences/
// https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
import java.util.*;

public class Q8_DistinctSubs {

    // Recursive Way
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        return countDistinctSubs(s, t, n-1, m-1);
    }
    private int countDistinctSubs(String s, String t, int i, int j) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
            return countDistinctSubs(s, t, i-1, j-1) + countDistinctSubs(s, t, i-1, j);

        return countDistinctSubs(s, t, i-1, j);
    }

    // DP-1: Memoization
    public int numDistinct_mem(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return countDistinctSubs(s, t, n-1, m-1, dp);
    }
    private int countDistinctSubs(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return countDistinctSubs(s, t, i-1, j-1, dp) + countDistinctSubs(s, t, i-1, j, dp);

        return countDistinctSubs(s, t, i-1, j, dp);
    }

    // DP-2: Tabulation
    public int numDistinct_tab(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][m];
    }

    // DP-3: Space Optimization 1
    public int numDistinct_so1(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = dp[j-1] + dp[j];
                else
                    curr[j] = dp[j];
            }
            dp = curr;
        }

        return dp[m];
    }

    // DP-4: Space Optimization 2
    public int numDistinct_so2(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[j] = dp[j-1] + dp[j];
            }
        }

        return dp[m];
    }
}
