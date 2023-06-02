package Day1_Arrays_I;

public class Q4_KadanesAlgo {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }

        return max;
    }
}
