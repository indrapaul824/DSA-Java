package Practice.Algorithms.SDOT;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
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
}
