package Day10_Recursion_Backtrack;
import java.util.*;

public class Q1_PrintAllPerms {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, res, nums);
        return res;
    }

    private void solve(int ind, List<List<Integer>> res, int[] nums) {
        if (ind == nums.length) {
            res.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            solve(ind+1, res, nums);
            swap(nums, ind, i);
        }
    }

    private void swap(int[] nums, int ind, int i) {
        int temp = nums[ind];
        nums[ind] = nums[i];
        nums[i] = temp;
    }

}
