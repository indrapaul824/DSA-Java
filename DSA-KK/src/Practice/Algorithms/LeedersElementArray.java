package Practice.Algorithms;

import java.util.Scanner;

public class LeedersElementArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        System.out.println("The Leeder's elements are: ");
        printElem(arr, n);
    }

    public static void printElem(int[] arr, int n) {
        for (int i =0; i < n-1; i++)
            if (arr[i] > arr[i+1])
                System.out.print(arr[i] + ", ");

        System.out.println(arr[n-1]);
    }
}
