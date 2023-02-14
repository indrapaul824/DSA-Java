package Leetcode;

import utils.Main.*;
import java.util.*;

public class FindPivot {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int[] nums = {-1,-1,0,1,0,-1};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        int ls = 0, rs = 0;
        for (int num : nums) rs += num;
        int i = 0;
        while (i < nums.length) {
            if (ls == rs-ls-nums[i])
                return i;
            ls += nums[i];
            i++;
        }
        return -1;
    }
}
