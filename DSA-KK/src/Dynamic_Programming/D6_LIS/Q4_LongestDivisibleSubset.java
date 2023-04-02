package Dynamic_Programming.D6_LIS;
import java.util.*;

public class Q4_LongestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int max_ind = 0;

        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                max_ind = i;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[max_ind]);
        while (hash[max_ind] != max_ind) {
            max_ind = hash[max_ind];
            temp.add(0, nums[max_ind]);
        }
        return temp;
    }
}
