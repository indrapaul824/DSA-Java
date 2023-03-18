package Dynamic_Programming.D4_Strings;

// https://leetcode.com/problems/shortest-common-supersequence
// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

public class Q7_SCS {

    // Return the length
    public static int shortestCommonSupersequence(String word1,String word2,int n,int m)
    {
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

        return n+m-lcs;
    }

    // Print the sequence
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int i = n, j = m;
        StringBuilder s = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                s.insert(0, str1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                s.insert(0, str1.charAt(i-1));
                i--;
            }
            else {
                s.insert(0, str2.charAt(j-1));
                j--;
            }
        }
        while (i > 0) {
            s.insert(0, str1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            s.insert(0, str2.charAt(j-1));
            j--;
        }

        return s.toString();
    }
}
