package Practice.Algorithms.SDOT;

import java.util.HashMap;
import java.util.Map;

public class CountKDivPairSum {
    public static int countKDivPairs(int[] arr, int n, int k) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((arr[i] + arr[j]) % k == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    public static long countKDivPairs_opt(int[] arr, int n, int k) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int item : arr) {
            int rem = item % k;
            if (rem != 0)
                count += map.getOrDefault(k - rem, 0);
            else
                count += map.getOrDefault(0, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
