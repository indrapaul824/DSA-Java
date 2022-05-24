package Arrays;

import java.util.Arrays;

import static Arrays.A8_Swap.swap;

public class A10_Reverse {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 5, 13};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reversed array is: " + Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap the values
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
