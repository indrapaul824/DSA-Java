package Practice.Algorithms;

import java.util.*;

public class AlternatePosNegNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        System.out.println(Arrays.toString(arr));

        generateAltArray(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    public static void generateAltArray(int[] arr, int n) {
        int i = 0, j = 1;

        while (i < n && j < n) {
            if (arr[i] >= 0)
                i += 2;
            else if (arr[j] < 0)
                j += 2;
            else {
                swap(arr, i, j);
                i += 2;
                j += 2;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
