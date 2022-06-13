package Arrays.Sorting;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        int i=0;

        while (i<n) {
            int key = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            i++;
        }
    }
}
