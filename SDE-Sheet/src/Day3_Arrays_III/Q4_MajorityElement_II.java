package Day3_Arrays_III;
import java.util.*;

public class Q4_MajorityElement_II {
    // Better
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (var it : map.entrySet()) {
            if (it.getValue() > nums.length/3)
                res.add(it.getKey());
        }

        return res;
    }

    // Optimal

}
