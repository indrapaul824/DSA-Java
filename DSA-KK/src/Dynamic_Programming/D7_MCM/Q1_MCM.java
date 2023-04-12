package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q1_MCM {
    // Recursive Approach
    static int matrixMultiplication(int N, int[] arr)
    {
        return mcm(1, N-1, arr);
    }
    static int mcm(int i, int j, int[] arr) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i-1]*arr[k]*arr[j]
                    + mcm(i, k, arr) + mcm(k+1, j, arr);
            min = Math.min(min, steps);
        }

        return min;
    }

    // DP-1: Memoization
    static int matrixMultiplication_mem(int N, int[] arr)
    {
        int[][] dp = new int[N][N];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return mcm(1, N-1, arr, dp);
    }
    static int mcm(int i, int j, int[] arr, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i-1]*arr[k]*arr[j]
                    + mcm(i, k, arr, dp) + mcm(k+1, j, arr, dp);
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }

    // DP-2: Tabulation

}
