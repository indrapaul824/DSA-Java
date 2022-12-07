package Practice.Algorithms;

import java.util.*;

public class ArraySpProd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        System.out.println(Arrays.toString(arr));
        spProd(arr, n);

        System.out.println(Arrays.toString(arr));
    }

    public static void spProd(int[] arr, int n) {
        int prod = arrProd(arr, n);

        for (int i = 0; i < arr.length; i++)
            arr[i] = prod / arr[i];
    }

    public static int arrProd(int[] arr, int n) {
        int prod = 1;

        for (int j : arr)
            prod = prod * j;

        return prod;
    }
}
