package Recursion;

import utils.Main.*;
import java.util.*;

public class Q9_CombSum_II {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(combSum(arr, target));
        System.out.println(combinationSum2(arr, target));
    }

    private static List<List<Integer>> combSum(int[] arr, int target) {
        Set<List<Integer>> res = new HashSet<>();
        findCombs(0, arr, target, res, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private static void findCombs(int i, int[] arr, int target, Set<List<Integer>> res, ArrayList<Integer> ds) {
        if (i == arr.length) {
            if (target == 0)
                res.add(new ArrayList<>(ds));
            return;
        }
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombs(i+1, arr, target-arr[i], res, ds);
            ds.remove(ds.size()-1);
        }
        findCombs(i+1, arr, target, res, ds);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombs(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    private static void findCombs(int ind, int[] arr, int target, List<List<Integer>> res, ArrayList<Integer> ds) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i-1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombs(i+1, arr, target - arr[i], res, ds);
            ds.remove(ds.size()-1);
        }
    }
}
