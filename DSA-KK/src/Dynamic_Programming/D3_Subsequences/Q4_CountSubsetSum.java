package Dynamic_Programming.D3_Subsequences;

// https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
import java.util.*;

public class Q4_CountSubsetSum {

    // Recursion from Top
    public int perfectSum_bt(int[] arr, int n, int sum)
    {
        return countPerfectSum(0, 0, sum, arr, n);
    }
    private static int countPerfectSum(int i, int s, int sum, int[] arr, int n) {
        if (i == n) {
            if (s == sum)
                return 1;
            return 0;
        }
        s += arr[i];
        int l = countPerfectSum(i+1, s, sum, arr, n);

        s -= arr[i];
        int r = countPerfectSum(i+1, s, sum, arr, n);

        return l+r;
    }

    static int mod = (int)1e9+7;

    // Recursion from bottom
    // 104/323 - TLE
    public static int perfectSum(int[] arr, int n, int sum) {
        return count(arr, n-1, sum);
    }
    private static int count(int[] arr, int ind, int tar) {
        if (ind == 0) {
            if (tar == 0 && arr[ind] == tar)
                return 2;
            else if (tar == 0 || arr[ind] == tar)
                return 1;
            else
                return 0;
        }

        int not_pick = count(arr, ind-1, tar);
        int pick = 0;
        if (tar >= arr[ind])
            pick = count(arr, ind-1, tar-arr[ind]);

        return (pick + not_pick) % mod;
    }

    // DP-1: Memoization (from bottom)
    // AC
    public static int perfectSum_mem(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return count(arr, n-1, sum, dp);
    }
    private static int count(int[] arr, int ind, int tar, int[][] dp) {
        if (dp[ind][tar] != -1)
            return dp[ind][tar];

        if (ind == 0) {
            if (tar == 0 && arr[0] == 0)
                return 2;
            else if (tar == 0 || arr[0] == tar)
                return 1;
            else
                return 0;
        }

        int not_pick = count(arr, ind-1, tar, dp);
        int pick = 0;
        if (tar >= arr[ind])
            pick = count(arr, ind-1, tar-arr[ind], dp);

        return dp[ind][tar] = (pick + not_pick) % mod;
    }

    // DP-2: Tabulation
    public int perfectSum_tab(int[] arr,int n, int sum) {
        int[][] dp = new int[n][sum+1];

        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] <= sum)
            dp[0][arr[0]] = 1;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                int not_pick = dp[i-1][j];
                int pick = 0;
                if (j >= arr[i] && j-arr[i] >= 0)
                    pick = dp[i-1][j-arr[i]];

                dp[i][j] = (pick + not_pick) % mod;
            }
        }
        return dp[n-1][sum];
    }

    // DP-3: Space Optimisation
    public int perfectSum_so(int[] arr,int n, int sum) {
        int[] dp = new int[sum+1];

        if (arr[0] == 0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if (arr[0] != 0 && arr[0] <= sum)
            dp[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[sum+1];
            for (int j = 0; j <= sum; j++) {
                int not_pick = dp[j];
                int pick = 0;
                if (j >= arr[i] && j-arr[i] >= 0)
                    pick = dp[j-arr[i]];

                curr[j] = (pick + not_pick) % mod;
            }
            dp = curr;
        }
        return dp[sum];
    }

}
