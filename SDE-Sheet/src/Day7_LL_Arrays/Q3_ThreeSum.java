package Day7_LL_Arrays;
import java.util.*;

public class Q3_ThreeSum {
    // Better
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>  uniqueTriplets = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                int k = - (nums[i] + nums[j]);
                if (set.contains(k)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(k);
                    Collections.sort(list);
                    uniqueTriplets.add(list);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    // Optimal
    public List<List<Integer>> threeSum_opti(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // O(N logN)

        for (int i = 0; i < nums.length; i++) {     // O(N)
            // We set i for every duplicate set's 1st elem
            if (i > 0 && nums[i] == nums[i-1])  continue;

            int j = i+1, k = nums.length - 1;

            while (j < k) {     // O(N) even including the below while loops
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    List<Integer> trip = new ArrayList<>(); // Constant space
                    trip.add(nums[i]);
                    trip.add(nums[j]);
                    trip.add(nums[k]);
                    res.add(trip);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j-1])    j++;
                    while (j < k && nums[k] == nums[k+1])    k--;
                }
            }
        }

        return res;
    }
}
