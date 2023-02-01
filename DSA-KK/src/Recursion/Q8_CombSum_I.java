package Recursion;

import utils.Main.*;
import java.util.*;

public class Q8_CombSum_I {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(combSum(arr, target));
    }

    private static List<List<Integer>> combSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        findCombs(0, arr, target, res, new ArrayList<>());
        return res;
    }

    private static void findCombs(int i, int[] arr, int target, List<List<Integer>> res, ArrayList<Integer> ds) {
        if (i == arr.length) {
            if (target == 0)
                res.add(new ArrayList<>(ds));
            return;
        }
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombs(i, arr, target-arr[i], res, ds);
            ds.remove(ds.size()-1);
        }
        findCombs(i+1, arr, target, res, ds);
    }
}
