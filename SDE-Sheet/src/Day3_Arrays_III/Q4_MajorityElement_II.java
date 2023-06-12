package Day3_Arrays_III;
import java.util.*;

public class Q4_MajorityElement_II {
    // Better
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if (map.get(n) == nums.length/3 + 1)
                res.add(n);
        }

        return res;
    }

    // Optimal
    public List<Integer> majorityElement_opti(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (cnt1 == 0 && n != ele2) {
                cnt1 = 1;
                ele1 = n;
            }
            else if (cnt2 == 0 && n != ele1) {
                cnt2 = 1;
                ele2 = n;
            }

            else if (ele1 == n)
                cnt1++;
            else if (ele2 == n)
                cnt2++;

            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int n : nums) {
            if (ele1 == n)  cnt1++;
            if (ele2 == n)  cnt2++;
        }
        int min = nums.length / 3;
        if (cnt1 > min)
            res.add(ele1);
        if (cnt2 > min)
            res.add(ele2);

        return res;
    }
}
