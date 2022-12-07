package Practice.Algorithms;

import java.util.Scanner;

public class MaxProdSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        System.out.println("The maximum product of a sub-array is: " + maxProd(arr, n));
    }

    public static int maxProd(int[] arr, int n) {
        int max = 0, prod = 1;

        for (int i = 0; i < n; i++) {
            prod *= arr[i];

            if (prod > max)
                max = prod;

            if (prod == 0)
                prod = 1;
        }

        return max;
    }
}
