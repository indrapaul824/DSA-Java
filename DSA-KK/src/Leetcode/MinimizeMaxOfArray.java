package Leetcode;

public class MinimizeMaxOfArray {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0, prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            ans = Math.max(ans, (prefixSum + i) / (i + 1));
        }

        return (int)ans;
    }
}
