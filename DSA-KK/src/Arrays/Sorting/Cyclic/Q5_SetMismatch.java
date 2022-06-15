package Arrays.Sorting.Cyclic;

// Q 5 : Find the repeated and the lost number from a set of integers ranging from [1, N]
// https://leetcode.com/problems/set-mismatch/

import java.util.Arrays;

public class Q5_SetMismatch {
    public static void main(String[] args) {
        int[] arr = {8,7,3,5,3,6,1,4};
        System.out.println("The duplicate element is: " + Arrays.toString(findMismatch(arr)));
    }

    public static int[] findMismatch(int[] arr) {
        int i = 0, n = arr.length;

        while (i < n) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j+1)
                return new int[]{arr[j], j+1};
        }

        return new int[]{-1, -1};
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
