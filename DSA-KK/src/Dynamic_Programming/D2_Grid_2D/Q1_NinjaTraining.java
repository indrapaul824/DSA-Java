package Dynamic_Programming.D2_Grid_2D;

import utils.Main.*;
import java.util.*;

public class Q1_NinjaTraining {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = in.nextInt();
            }
        }
        System.out.println(maxPoints(points, n));
        System.out.println(maxPoints_mem(points, n));
        System.out.println(maxPoints_tab(points, n));
        System.out.println(maxPoints_so(points, n));
    }

    // Recursive Way
    private static int maxPoints(int[][] points, int n) {
        return ninjaTraining(points, n-1, 3);
    }

    private static int ninjaTraining(int[][] points, int day, int last) {
        if (day == 0) {
            int max_i = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    max_i = Math.max(max_i, points[0][i]);
            }
            return max_i;
        }
        int max_i = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[day][i]
                        + ninjaTraining(points, day-1, i);
                max_i = Math.max(max_i, point);
            }
        }
        return max_i;
    }

    // DP-1: Memoization
    private static int maxPoints_mem(int[][] points, int n) {
        int[][] dp = new int[n][4];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return ninjaTraining(points, n-1, 3, dp);
    }

    private static int ninjaTraining(int[][] points, int day, int last, int[][] dp) {
        if (day == 0) {
            int max_i = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    max_i = Math.max(max_i, points[0][i]);
            }
            return max_i;
        }
        if (dp[day][last] != -1)
            return dp[day][last];
        int max_i = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[day][i]
                        + ninjaTraining(points, day-1, i, dp);
                max_i = Math.max(max_i, point);
            }
        }
        return dp[day][last] = max_i;
    }

    // DP-2: Tabulation
    private static int maxPoints_tab(int[][] points, int n) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max_i = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int point = points[day][i] + dp[day - 1][i];
                        max_i = Math.max(point, max_i);
                    }
                }
                dp[day][last] = max_i;
            }
        }
        return dp[n-1][3];
    }

    // DP-3: Space Optimisation
    private static int maxPoints_so(int[][] points, int n) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];
            for (int last = 0; last < 4; last++) {
                curr[last] = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int point = points[day][i] + dp[i];
                        curr[last] = Math.max(point, curr[last]);
                    }
                }
            }
            dp = curr;
        }
        return dp[3];
    }
}
