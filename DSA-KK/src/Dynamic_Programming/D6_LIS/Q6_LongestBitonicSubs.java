package Dynamic_Programming.D6_LIS;

import java.util.Arrays;
import java.util.Collections;

public class Q6_LongestBitonicSubs {
    public int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // LIS DP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
        }

        int max = -1;
        // LDS DP and LBS computation
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[i] > nums[j])
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        return max;
    }
}
