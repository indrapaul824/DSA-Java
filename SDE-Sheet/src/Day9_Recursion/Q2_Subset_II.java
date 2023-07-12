package Day9_Recursion;
import java.util.*;

public class Q2_Subset_II {
    private void solve(int ind, List<Integer> ds, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i-1])  continue;

            ds.add(nums[i]);
            solve(i+1, ds, res, nums);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(0, ds, res, nums);
        return res;
    }
}
