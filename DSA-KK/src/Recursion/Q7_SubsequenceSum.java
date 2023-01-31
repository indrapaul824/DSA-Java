package Recursion;

import utils.Main.*;

import java.util.*;

public class Q7_SubsequenceSum {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sum = in.nextInt();
        System.out.println(perfectSum(arr, n, sum));
        List<Integer> ds = new ArrayList<>();
        subseqSumOne(0, ds, 0, sum, arr, n);
        System.out.println(countPerfectSum(0, 0, sum, arr, n));
    }


    private static int perfectSum(int[] arr, int n, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subseqSum(0, ds, 0, sum, list, arr, n);
        System.out.println(list);
        return list.size();
    }

    private static void subseqSum(int i, List<Integer> ds, int s, int sum, List<List<Integer>> list, int[] arr, int n) {
        if (i == n) {
            if (s == sum)
                list.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[i]);
        s += arr[i];
        subseqSum(i+1, ds, s, sum, list, arr, n);
        ds.remove(ds.size()-1);
        s -= arr[i];
        subseqSum(i+1, ds, s, sum, list, arr, n);
    }

    private static boolean subseqSumOne(int i, List<Integer> ds, int s, int sum, int[] arr, int n) {
        if (i == n) {
            if (s == sum) {
                System.out.println(ds);
                return true;
            }
            return false;
        }
        ds.add(arr[i]);
        s += arr[i];
        if (subseqSumOne(i+1, ds, s, sum, arr, n))
            return true;
        ds.remove(ds.size()-1);
        s -= arr[i];
        return subseqSumOne(i + 1, ds, s, sum, arr, n);
    }

    private static int countPerfectSum(int i, int s, int sum, int[] arr, int n) {
        if (i == n) {
            if (s == sum)
                return 1;
            return 0;
        }
        s += arr[i];
        int l = countPerfectSum(i+1, s, sum, arr, n);

        s -= arr[i];
        int r = countPerfectSum(i+1, s, sum, arr, n);

        return l+r;
    }
}
