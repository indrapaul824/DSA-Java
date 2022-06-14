package Arrays.Sorting.Cyclic;

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
        int i = 0;

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
