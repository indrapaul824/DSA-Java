package Leetcode;

public class Num0_filledSubArrays {

    // Naive Approach using Recursion
    public static long zeroFilledSubarray(int[] nums) {
        int cnt = 0;
        long sum = 0;
        for (int n : nums) {
            if (n == 0)
                cnt++;
            else if (cnt > 0) {
                sum += countSub(cnt);
                cnt = 0;
            }
        }
        if (cnt > 0) {
            sum += countSub(cnt);
        }
        return sum;
    }

    public static long countSub(int n) {
        if (n == 1)
            return 1;

        return n + countSub(n-1);
    }

    // Optimal Approach
    public static long zeroFilledSubarray_op(int[] nums) {
        int cnt = 0;
        long sum = 0;
        for (int n : nums) {
            if (n == 0)
                cnt++;
            else
                cnt = 0;
            sum += cnt;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 0, 0};
        System.out.println(zeroFilledSubarray(nums));
    }
}
