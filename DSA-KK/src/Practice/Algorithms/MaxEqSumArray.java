package Practice.Algorithms;

import utils.Main.*;
import java.util.stream.IntStream;

public class MaxEqSumArray {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("The Max Equilibrium Sum is: " + findMaxEqSum(arr, n));
    }

    private static int findMaxEqSum(int[] arr, int n) {
        int right_sum = IntStream.of(arr).sum();
        int left_sum = 0, res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            right_sum -= arr[i];

            if (left_sum == right_sum)
                res = Math.max(res, left_sum);
            left_sum += arr[i];

        }

        return res;
    }
}
