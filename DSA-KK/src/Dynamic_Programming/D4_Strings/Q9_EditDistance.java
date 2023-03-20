package Dynamic_Programming.D4_Strings;

import java.util.*;

public class Q9_EditDistance {
    // Recursive Way
    public int minDistance(String s, String t) {
        int n = s.length(), m = t.length();
        return findMinDist(n-1, m-1, s, t);
    }
    private static int findMinDist(int i, int j, String s, String t) {
        // Base Case
        // s -> exhausted --> Empty s to t will take j+1 insertions
        if (i < 0) return j+1;
        // t -> exhausted --> s to empty t will take i+1 deletions
        if (j < 0) return i+1;

        // Trying all possibilities

        // If char matches
        // No operations needed
        // 0 + min(prev chars)
        if (s.charAt(i) == t.charAt(j))
            return 0 + findMinDist(i-1, j-1, s, t);

        // If char doesn't match
        // 3 options for operations:
        // 1. Insert
        int in = 1 + findMinDist(i, j-1, s, t);
        // 2. Delete
        int del = 1 + findMinDist(i-1, j, s, t);
        // 3. Replace
        int repl = 1 + findMinDist(i-1, j-1, s, t);
        return Math.min(in, Math.min(del, repl));
    }

    // DP-1: Memoization
    public int minDistance_mem(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return findMinDist(n-1, m-1, s, t, dp);
    }
    private static int findMinDist(int i, int j, String s, String t, int[][] dp) {
        // Base Case
        // s -> exhausted --> Empty s to t will take j+1 insertions
        if (i < 0) return j+1;
        // t -> exhausted --> s to empty t will take i+1 deletions
        if (j < 0) return i+1;

        // Check in dp if already calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // Trying all possibilities

        // If char matches
        // No operations needed
        // 0 + min(prev chars)
        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = 0 + findMinDist(i-1, j-1, s, t, dp);

        // If char doesn't match
        // 3 options for operations:
        // 1. Insert
        int in = 1 + findMinDist(i, j-1, s, t, dp);
        // 2. Delete
        int del = 1 + findMinDist(i-1, j, s, t, dp);
        // 3. Replace
        int repl = 1 + findMinDist(i-1, j-1, s, t, dp);
        return dp[i][j] = Math.min(in, Math.min(del, repl));
    }

    // DP-2: Tabulation
    public int minDistance_tab(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        // Base Cases
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    // 1. Insert
                    int in = 1 + dp[i][j-1];
                    // 2. Delete
                    int del = 1 + dp[i-1][j];
                    // 3. Replace
                    int repl = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(in, Math.min(del, repl));
                }
            }
        }

        return dp[n][m];
    }

    // DP-3: Space Optimization
    public int minDistance_so(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m+1];

        // Base case for dp[0][j] = j;
        for (int j = 0; j <= m; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            // Base case for dp[i][0] = i;
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = dp[j - 1];
                else {
                    // 1. Insert
                    int in = curr[j-1];
                    // 2. Delete
                    int del = dp[j];
                    // 3. Replace
                    int repl = dp[j-1];
                    curr[j] = 1 + Math.min(in, Math.min(del, repl));
                }
            }
            dp = curr;
        }

        return dp[m];
    }
}
