package Dynamic_Programming.OneDim;

import utils.Main.*;
import java.util.*;
public class Q2_FrogJump {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = Arrays.stream(in.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(frogJump(arr, n));
    }

    private static int frogJump(int[] arr, int n) {
        return 0;
    }
}
