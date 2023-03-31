package Dynamic_Programming.D6_LIS;
import java.util.*;

public class Q2_PrintLIS {
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int[] nums){
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int max_ind = 0;
        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for (int prev = 0; prev < ind; prev++) {
                if (nums[ind] > nums[prev] && 1 + dp[prev] > dp[ind]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            if (dp[ind] > max) {
                max = dp[ind];
                max_ind = ind;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, nums[max_ind]);
        while (hash[max_ind] != max_ind) {
            max_ind = hash[max_ind];
            list.add(0, nums[max_ind]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 11, 1, 16, 8};
        int n = 6;
        System.out.println(longestIncreasingSubsequence(n, nums));
    }
}
