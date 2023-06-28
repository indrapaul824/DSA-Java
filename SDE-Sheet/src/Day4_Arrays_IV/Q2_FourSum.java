package Day4_Arrays_IV;
import java.util.*;

public class Q2_FourSum {

    // Better Approach
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> quads = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Set<Long> set = new HashSet<>();

                for (int k = j+1; k < n; k++) {
                    long l = (long)target - ((long)nums[i] + nums[j] + nums[k]);

                    if (set.contains(l)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)l);
                        Collections.sort(list);
                        quads.add(list);
                    }

                    set.add((long)nums[k]);
                }
            }
        }

        return new ArrayList<>(quads);
    }

    // Optimal
    public List<List<Integer>> fourSum_opt(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1])  continue;

            for (int j = i+1; j < n; j++) {
                if (j > i+1 && nums[j] == nums[j-1])  continue;

                int k = j+1, l = n-1;

                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k] + nums[l];

                    if (sum > target)
                        l--;
                    else if (sum < target)
                        k++;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k-1])   k++;
                        while (k < l && nums[l] == nums[l+1])   l--;
                    }
                }
            }
        }

        return res;
    }
}
