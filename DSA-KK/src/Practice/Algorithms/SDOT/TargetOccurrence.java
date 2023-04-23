package Practice.Algorithms.SDOT;
import utils.Main.*;
import java.util.*;

public class TargetOccurrence {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        List<Integer> list = new ArrayList<>();
        targetOcc(0, arr, target, list);
        System.out.println(list);
    }

    private static void targetOcc(int i, int[] arr, int target, List<Integer> list) {
        if (i == arr.length)
            return;
        if (arr[i] == target)
            list.add(i);

        targetOcc(i+1, arr, target, list);
    }
}
