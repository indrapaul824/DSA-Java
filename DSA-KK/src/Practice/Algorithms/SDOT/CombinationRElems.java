package Practice.Algorithms.SDOT;
import utils.Main.*;

import java.util.ArrayList;
import java.util.List;

public class CombinationRElems {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int r = in.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        printComb(0, arr, r, ds, list);
        System.out.println(list);
    }

    private static void printComb(int i, int[] arr, int r, List<Integer> ds, List<List<Integer>> list) {
        if (ds.size() == r) {
            list.add(new ArrayList<>(ds));
            return;
        }

        if (i >= arr.length)
            return;

        ds.add(arr[i]);
        printComb(i+1, arr, r, ds, list);
        ds.remove(ds.size() - 1);

        printComb(i+1, arr, r, ds, list);
    }
}
