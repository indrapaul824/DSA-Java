package Dynamic_Programming.D4_Strings;

// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

import java.util.Arrays;

public class Q3_LC_SubString {
    // DP-2: Tabulation
    public static int longestCommonSubstring(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    // DP-3: Space Optimization
    public static int longestCommonSubstring_so(String S1, String S2, int n, int m){
        int[] dp = new int[m+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int[] curr= new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i-1) == S2.charAt(j-1)) {
                    curr[j] = 1 + dp[j-1];
                    max = Math.max(max, curr[j]);
                }
            }
            dp = curr;
        }

        return max;
    }
}
