package Dynamic_Programming.D6_LIS;

import java.util.ArrayList;
import java.util.List;

public class Q3_LIS_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size()-1))
                temp.add(nums[i]);
            else {
                int ind = lower_bound(temp, nums[i]);
                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }

    private int lower_bound(List<Integer> temp, int target) {
        int low = 0;
        int high = temp.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (temp.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
