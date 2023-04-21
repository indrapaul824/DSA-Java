package Practice.Algorithms.PLA1001;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] req = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    req[0] = i;
                    req[1] = j;
                    return req;
                }
            }
        }

        return req;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = {3, 3};

        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
