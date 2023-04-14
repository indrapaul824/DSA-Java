package Dynamic_Programming.D7_MCM;
import java.util.*;

public class Q3_BurstBalloons {
    // Recursive Approach
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.add(0, 1);
        list.add(1);
        int n = nums.length;
        return maxSumCoins(1, n, list);
    }

    private int maxSumCoins(int i, int j, List<Integer> list) {
        if (i > j)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = list.get(i-1) * list.get(ind) * list.get(j+1)
                    + maxSumCoins(i, ind -1, list)
                    + maxSumCoins(ind+1, j, list);
            max = Math.max(max, coins);
        }

        return max;
    }

    // DP-1: Memoization
    public int maxCoins_mem(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.add(0, 1);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return maxSumCoins(1, n, list, dp);
    }
    private int maxSumCoins(int i, int j, List<Integer> list, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = list.get(i-1) * list.get(ind) * list.get(j+1)
                        + maxSumCoins(i, ind -1, list, dp)
                        + maxSumCoins(ind+1, j, list, dp);
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }

    // DP-2: Tabulation
    public int maxCoins_tab(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.add(0, 1);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];

        for(int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int max = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = list.get(i-1) * list.get(ind) * list.get(j+1)
                            + dp[i][ind - 1]
                            + dp[ind + 1][j];
                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}
