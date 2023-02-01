package Recursion;

import utils.Main.*;
import java.util.*;

public class Q12_Permutations {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(permutations(arr));
    }

    private static List<List<Integer>> permutations(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
//        boolean[] freq = new boolean[arr.length];
//        findPerm(arr, new ArrayList<>(), res, freq);
        findPerm(0, arr, res);
        return res;
    }

    private static void findPerm(int[] arr, ArrayList<Integer> ds, List<List<Integer>> res, boolean[] freq) {
        if (ds.size()==arr.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                findPerm(arr, ds, res, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    private static void findPerm(int ind, int[] arr, List<List<Integer>> res) {
        if (ind == arr.length) {
            res.add(Arrays.stream(arr).boxed().toList());
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind, arr);
            findPerm(ind+1, arr, res);
            swap(i, ind, arr);
        }
    }
    public static void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
