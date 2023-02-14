package Leetcode;
import java.util.*;
import utils.Main.*;
public class FairPair {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        long cnt = 0;
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] + nums[n] >= lower && upper - nums[i] >= nums[i]) {
                for (int j = i + 1; j < n; j++) {
                    int s = nums[i] + nums[j];
                    if (s >= lower && s <= upper)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[] nums = {1,7,9,2,5};
        int lower = 11, upper = 11;
        System.out.println(countFairPairs(nums, lower, upper));
    }
}
