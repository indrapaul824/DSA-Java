package Recursion;
import utils.Main.*;
import java.util.*;

public class Q11_SubsetSum_II {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(subsetWD(arr));
    }

    private static List<List<Integer>> subsetWD(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), res);
        return res;
    }

    private static void findSubsets(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> res) {
        res.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            findSubsets(i+1, arr, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}
