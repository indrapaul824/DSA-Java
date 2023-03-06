package Dynamic_Programming.D3_Subsequences;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
import java.util.*;

public class Q1_SubsetSum {
    // Recursive Way
    static Boolean isSubsetSum(int N, int[] arr, int sum){
        return checkSub(arr, N-1, sum);
    }
    public static Boolean checkSub(int[] arr, int ind, int sum) {
        if (sum == 0)
            return true;
        if (ind == 0)
            return (arr[ind] == sum);

        boolean not_pick = checkSub(arr, ind-1, sum);

        boolean pick = false;
        if (sum >= arr[ind])
            pick = checkSub(arr, ind-1, sum-arr[ind]);

        return (pick || not_pick);
    }

    // DP-1: Memoization
    static Boolean isSubsetSum_mem(int N, int[] arr, int sum){
        int[][] dp = new int[N][sum+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return checkSub(arr, N-1, sum, dp);
    }
    public static Boolean checkSub(int[] arr, int ind, int sum, int[][] dp) {
        if (sum == 0)
            return true;
        if (ind == 0)
            return (arr[ind] == sum);

        if (dp[ind][sum] != -1)
            return dp[ind][sum] != 0;

        boolean not_pick = checkSub(arr, ind-1, sum, dp);

        boolean pick = false;
        if (sum >= arr[ind])
            pick = checkSub(arr, ind-1, sum-arr[ind], dp);

        dp[ind][sum] = (pick || not_pick) ? 1 : 0;
        return (pick || not_pick);
    }

    // DP-2: Tabulation
    public static Boolean isSubsetSum_tab(int N, int[] arr, int sum){
        boolean[][] dp = new boolean[N][sum+1];
        for (int i = 0; i < N; i++)
            dp[i][0] = true;
        if(arr[0] <= sum)
            dp[0][arr[0]] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean not_pick = dp[i-1][j];
                boolean pick = false;
                if (sum >= arr[i] && j-arr[i] >= 0)
                    pick = dp[i-1][j-arr[i]];
                dp[i][j] = pick || not_pick;
            }
        }
        return dp[N-1][sum];
    }

    // DP-3: Space Optimization
    public static Boolean isSubsetSum_so(int N, int[] arr, int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        if(arr[0] <= sum)
            dp[arr[0]] = true;

        for (int i = 1; i < N; i++) {
            boolean[] curr = new boolean[sum+1];
            for (int j = 1; j <= sum; j++) {
                boolean not_pick = dp[j];
                boolean pick = false;
                if (sum >= arr[i] && j-arr[i] >= 0)
                    pick = dp[j-arr[i]];
                curr[j] = pick || not_pick;
            }
            dp = curr;
        }
        return dp[sum];
    }
}
