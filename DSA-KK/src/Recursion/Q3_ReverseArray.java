package Recursion;

import utils.Main.*;

import java.util.Arrays;

public class Q3_ReverseArray {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    // Using 2 pointers - left and right
    static void reverse(int[] arr, int l, int r) {
        if (l >= r)
            return;
        swap(arr, l, r);
        reverse(arr, l+1, r-1);
    }

    // Using 1 pointer
    static void reverse(int[] arr, int n) {
        if (n >= arr.length/2)
            return;

        swap(arr, n, arr.length - n - 1);
        reverse(arr, n + 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
