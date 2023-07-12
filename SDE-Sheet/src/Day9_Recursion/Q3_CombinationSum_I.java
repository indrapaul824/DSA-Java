package Day9_Recursion;
import java.util.*;

public class Q3_CombinationSum_I {
    private void solve(int i, int target, List<Integer> ds, List<List<Integer>> combs, int[] nums) {
        // Base
        if (i == nums.length) {
            if (target == 0)
                combs.add(new ArrayList<>(ds));
            return;
        }

        if (nums[i] <= target) {
            ds.add(nums[i]);
            solve(i, target - nums[i], ds, combs, nums);
            ds.remove(ds.size()-1);
        }
        solve(i+1, target, ds, combs, nums);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(0, target, ds, combs, candidates);
        return combs;
    }
}
