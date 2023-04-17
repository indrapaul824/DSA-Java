package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q5_PalindromePartition_II {
    public boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    // Recursive Approach
    public int minCut(String st) {
        return palinPart(0, st.length(), st) - 1;
    }

    public int palinPart(int i, int n, String s) {
        if (i == n)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalin(s, i, j)) {
                int cuts = 1 + palinPart(j+1, n, s);
                min = Math.min(min, cuts);
            }
        }
        return min;
    }
    // DP-1: Memoization
    public int minCut_mem(String st) {
        int n = st.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return palinPart(0, n, st, dp) - 1;
    }

    public int palinPart(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalin(s, i, j)) {
                int cuts = 1 + palinPart(j+1, n, s, dp);
                min = Math.min(min, cuts);
            }
        }
        return dp[i] = min;
    }

    // DP-2: Tabulation
    public int minCut_tab(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        for (int i = n-1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalin(s, i, j)) {
                    int cuts = 1 + dp[j+1];
                    min = Math.min(min, cuts);
                }
            }
            dp[i] = min;
        }

        return dp[0]-1;
    }
}
