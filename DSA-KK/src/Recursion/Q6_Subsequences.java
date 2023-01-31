package Recursion;

import utils.Main.*;

import java.util.ArrayList;
import java.util.List;

public class Q6_Subsequences {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subsequences(list, 0, ds, arr, arr.length);
        return list;
    }

    private static void subsequences(List<List<Integer>> result, int ind, List<Integer> ds, int[] arr, int n) {
        if (ind == n) {
            result.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[ind]);
        subsequences(result, ind+1, ds, arr, n);
        ds.remove(ds.size()-1);
        subsequences(result, ind+1, ds, arr, n);
    }
}
