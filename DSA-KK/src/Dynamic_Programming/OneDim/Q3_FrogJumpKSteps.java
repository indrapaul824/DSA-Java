package Dynamic_Programming.OneDim;

import static java.lang.Math.*;
import utils.Main.*;
import java.util.*;

public class Q3_FrogJumpKSteps {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(minEnergy(arr, n, k));
        System.out.println(minEnergy_mem(arr, n, k));
        System.out.println(minEnergy_tab(arr, n, k));
        System.out.println(minEnergy_so(arr, n, k));
    }

    private static int minEnergy(int[] arr, int n, int k) {
        return frogJump(arr, n-1);
    }
    private static int frogJump(int[] arr, int ind) {
        if (ind == 0)
            return 0;
        int left = frogJump(arr, ind - 1) + abs(arr[ind] - arr[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = frogJump(arr, ind - 2) + abs(arr[ind] - arr[ind - 2]);

        return min(left, right);
    }
    private static int minEnergy_mem(int[] arr, int n, int k) {
        return 0;
    }
    private static int minEnergy_tab(int[] arr, int n, int k) {
        return 0;
    }
    private static int minEnergy_so(int[] arr, int n, int k) {
        return 0;
    }
}
