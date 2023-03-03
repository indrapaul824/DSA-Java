package Dynamic_Programming.D1_OneDim;

import utils.Main.*;
import java.util.*;

public class Q5_HouseRobber2 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] num1 = new int[n-1], num2 = new int[n-1];
        for (int i = 0; i < n; i++) {
            if (i != 0)
                num1[i-1] = nums[i];
            if (i != n-1)
                num2[i] = nums[i];
        }
        return Math.max(findMax(num1), findMax(num2));
    }

    // DP-3: Space Optimization (Previous Question)
    private static int findMax(int[] arr) {
        int n = arr.length;
        int prev2 = 0, prev = arr[0], curr;
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int not_pick = prev;
            curr = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
