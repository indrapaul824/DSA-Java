package Arrays.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i=0; i < n; i++) {
            swapped = false;
            // Run the steps N-1 times
            for (int j=1; j < n-i; j++) {
                // For each step, the max item from the unsorted part will shift to the end
                if (arr[j] < arr[j-1]) {
                    // Swap elements if not in order
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }

            // If swapping doesn't occur, then the array must be sorted
            // Stop further iterations/steps if array is sorted
            if (!swapped)
                break;
        }
    }
}
