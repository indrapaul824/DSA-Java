package Arrays.Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i < n; i++) {
            while (arr[i] != i+1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
