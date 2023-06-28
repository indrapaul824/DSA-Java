package Day4_Arrays_IV;
import java.util.*;

public class Q4_LargestSubArrKSum {
    // Better Approach: Hashing
    // Optimal for -ve values
    int maxLen(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, len = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (prefixSum == k)
                len = Math.max(len, i+1);

            else if (map.containsKey(prefixSum - k))
                len = Math.max(len, i - map.get(prefixSum - k));

            map.putIfAbsent(prefixSum, i);
        }

        return len;
    }

    // Optimal Approach: Two Pointer
    // In case of Positive Numbers or 0s in array
    // Not work for -ve values
    int maxLen_tp(int[] arr, int n, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLen = 0;
        while (j < n) {
            sum += arr[j];

            while (sum > k) {
                sum -= arr[i];
                i++;
            }

            if (sum == k)
                maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }
}
