package Dynamic_Programming.D3_Subsequences;

// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1


import java.util.HashMap;

public class Q3_MinSumPartition {
    // Using DP on Subsequences
    // Submits successfully on GFG because there, the problem consists of an array with non-negative values only.
    // This solution doesn't work on Leetcode because there, the problem consists of negative integers too
    // and with target = -ve, dp[-ve] is impossible to construct
    public static int minimumDifference(int[] arr) {
        int N = arr.length;
        int sum = 0;
        for (int n : arr)
            sum += n;

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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[i])
                min = Math.min(min, Math.abs(i - (sum - i)));
        }
        return min;
    }


    public static int minimumDifference_ds(int[] arr) {
        int N = arr.length;
        int sum = 0;
        for (int n : arr)
            sum += n;

        HashMap<Integer, Boolean> dp = new HashMap<>();
        dp.put(0, true);
        if(arr[0] <= sum)
            dp.put(arr[0], true);

        for (int i = 1; i < N; i++) {
            HashMap<Integer, Boolean> curr = new HashMap<>();
            for (int j = 1; j <= sum; j++) {
                boolean not_pick = dp.getOrDefault(j, false);
                boolean pick = false;
                if (sum >= arr[i])
                    pick = dp.getOrDefault(j-arr[i], false);
                curr.put(j, pick || not_pick);
            }
            dp = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp.getOrDefault(i, false))
                min = Math.min(min, Math.abs(i - (sum - i)));
        }
        return min;
    }
}
