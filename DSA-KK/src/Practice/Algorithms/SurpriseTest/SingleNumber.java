package Practice.Algorithms.SurpriseTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Unique Element: " + unique(arr, n));
        System.out.println("Unique Element: " + unique_map(arr, n));
    }

    // For all valid test cases
    static int unique(int[] arr, int n) {
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    // For invalid test cases
    static int unique_map(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet()) {
            if (map.get(i) == 1)
                return i;
        }
        return -1;
    }
}
