package Arrays;

import java.util.Arrays;

public class A8_Swap {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 5, 13};
        System.out.println(Arrays.toString(arr));

        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        swap(arr, 3, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
