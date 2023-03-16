package Practice.ShomironSir;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        solve(arr, ds, list, freq);
        System.out.println(list);
    }

    private static void solve(int[] arr, List<Integer> ds, List<List<Integer>> list, boolean[] freq) {
        if (ds.size() == arr.length) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                solve(arr, ds, list, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

}
