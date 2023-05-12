package Leetcode;
import java.util.Arrays;

public class SolveQuesBrainpower {
    // Recursive Solution
    long solve(int i, int[][] questions) {
        if (i >= questions.length)
            return 0;

        long pick = questions[i][0] + solve(i+questions[i][1]+1, questions);
        long notPick = solve(i+1, questions);

        return Math.max(pick, notPick);
    }
    public long mostPoints(int[][] questions) {
        return solve(0, questions);
    }

    // DP-1: Memoization
    long solve(int i, int[][] questions, long[] dp) {
        if (i >= questions.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        long pick = questions[i][0] + solve(i+questions[i][1]+1, questions, dp);
        long notPick = solve(i+1, questions, dp);

        return dp[i] = Math.max(pick, notPick);
    }
    public long mostPoints_mem(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }

    // DP-2: Tabulation
    public long mostPoints_tab(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];

        for (int i = n-1; i >= 0; i--) {
            long notPick = dp[i+1];
            long pick = questions[i][0];
            int ind = i + questions[i][1] + 1;
            if (ind <= n)
                pick = questions[i][0] + dp[ind];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[0];
    }
}
