package Dynamic_Programming.D3_Subsequences;

// https://leetcode.com/problems/partition-equal-subset-sum/
// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
import java.util.*;

public class Q2_PartitionEqualSubsetSum {

    // Using the space optimized Subset Sum solution with target = Total Sum/2
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum%2 != 0)
            return false;
        return solve(nums.length, nums, sum/2);
    }
    public static Boolean solve(int N, int[] arr, int sum) {
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
