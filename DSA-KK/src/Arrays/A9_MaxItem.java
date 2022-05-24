package Arrays;

import java.util.Arrays;

public class A9_MaxItem {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 5, 13};
        System.out.println(Arrays.toString(arr));

        System.out.println("Max value is: " + max(arr));

        System.out.println("Max value from index 1 to 2 is: " + max_range(arr, 0, 1));
    }

    public static int max(int[] arr) {
        // Using for loop
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int max_range(int[] arr, int start, int end) {
        // Using for loop
        int max = arr[0];
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
