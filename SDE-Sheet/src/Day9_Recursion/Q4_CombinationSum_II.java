package Day9_Recursion;
import java.util.*;

public class Q4_CombinationSum_II {
    private void solve(int ind, int target, List<Integer> ds, List<List<Integer>> combs, int[] nums) {
        if (target == 0) {
            combs.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i-1])    continue;

            if (nums[i] <= target) {
                ds.add(nums[i]);
                solve(i+1, target - nums[i], ds, combs, nums);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combs = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(0, target, ds, combs, candidates);
        return combs;
    }
}
