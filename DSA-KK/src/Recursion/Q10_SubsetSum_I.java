package Recursion;
import utils.Main.*;
import java.util.*;
public class Q10_SubsetSum_I {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        System.out.println(subsetSum(arr, n));
    }

    public static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        subSum(0, 0, res, arr, n);
        Collections.sort(res);
        return res;
    }

    private static void subSum(int i, int sum, ArrayList<Integer> res, ArrayList<Integer> arr, int n) {
        if (i == arr.size()) {
            res.add(sum);
            return;
        }
        sum += arr.get(i);
        subSum(i+1, sum, res, arr, n);
        sum -= arr.get(i);

        subSum(i+1, sum, res, arr, n);
    }
}
