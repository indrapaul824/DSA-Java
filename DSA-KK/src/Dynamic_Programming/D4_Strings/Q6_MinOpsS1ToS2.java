package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/delete-operation-for-two-strings
// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

public class Q6_MinOpsS1ToS2 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] dp = new int[m+1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    curr[j] = 1 + dp[j-1];
                else
                    curr[j] = Math.max(dp[j], curr[j-1]);
            }
            dp = curr;
        }

        int lcs = dp[m];
        return n+m-(2*lcs);
    }
}
