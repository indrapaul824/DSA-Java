package Day3_Arrays_III;
import java.util.*;

public class Q3_MajorityElement {
    // Better
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > nums.length/2)
                return n;
        }

        return -1;
    }

    // Optimal - Moore's Voting Algo
    public int majorityElement_opti(int[] nums) {
        int cnt = 0, ele = 0;

        for (int n : nums) {
            if (cnt == 0)
                ele = n;
            if (ele == n)
                cnt++;
            else
                cnt--;
        }

        return ele;
    }
}
