package Day4_Arrays_IV;
import java.util.*;

public class Q1_TwoSum {
    // Better for Elements, Optimal for indexes
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};

            map.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }

    // Optimal for Elements, Not for indexes
    public int[] twoSum_optimal(int[] numbers, int target) {
        Arrays.sort(numbers);
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target)
                return new int[]{numbers[low], numbers[high]};
            else if (sum < target)
                low++;
            else
                high--;
        }

        return new int[]{-1, -1};
    }


    // GFG Solution -> Find all Pairs
    static class pair  {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public pair[] allPairs(long[] A, long[] B, long N, long M, long X) {
        ArrayList<pair> list = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            int p = Arrays.binarySearch(B, (X - A[i]));
            if (p >= 0)
                list.add(new pair(A[i], B[p]));
        }

        pair[] pair = new pair[list.size()];

        return list.toArray(pair);
    }
}
