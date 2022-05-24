package Arrays;

import java.util.Arrays;

public class A3_PassToFunc {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));

        change(nums);

        System.out.println(Arrays.toString(nums));
    }

    static void change(int[] arr) {
        arr[0] = 99;
    }
}
