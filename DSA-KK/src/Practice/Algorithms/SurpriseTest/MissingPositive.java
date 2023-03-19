package Practice.Algorithms.SurpriseTest;

import java.util.*;

public class MissingPositive {
    public static int firstMissingPositive(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1])
                swap(arr, i, arr[i] - 1);
            else
                i++;
        }

        for (int j = 1; j <= n; j++) {
            if (arr[j-1] != j)
                return j;
        }

        return n+1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(firstMissingPositive(arr, n));
    }
}
