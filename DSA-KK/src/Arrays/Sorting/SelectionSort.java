package Arrays.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i<n-1; i++) {
            int min = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
