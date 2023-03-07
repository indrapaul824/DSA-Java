package Dynamic_Programming.D3_Subsequences;

// https://leetcode.com/problems/target-sum/
// https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1

public class Q8_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length, target, nums);
    }
    public int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        sum -= d;
        if (sum < 0 || sum % 2 != 0)
            return 0;
        return perfectSum_so(arr, n, sum/2);
    }
    public static int perfectSum_so(int[] arr,int n, int sum) {
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

                curr[j] = (pick + not_pick);
            }
            dp = curr;
        }
        return dp[sum];
    }
}
