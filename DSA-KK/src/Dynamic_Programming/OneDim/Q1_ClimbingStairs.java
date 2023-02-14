package Dynamic_Programming.OneDim;

import utils.Main.*;

public class Q1_ClimbingStairs {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        int s_0 = 1, s_1 = 1, s_n;

        for (int i = 2; i <= n; i++) {
            s_n = s_0 + s_1;
            s_0 = s_1;
            s_1 = s_n;
        }

        return s_1;
    }
}
