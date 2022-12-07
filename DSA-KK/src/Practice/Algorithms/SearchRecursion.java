package Practice.Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        System.out.print("Enter the key to find: ");
        int key = in.nextInt();
        searchRec(arr, n-1, key);
    }

    public static void searchRec(int[] arr, int index, int key) {
        if (index < 0) {
            System.out.println("Element NOT found");
            return;
        }

        if (arr[index] == key) {
            System.out.println("Element found");
            return;
        }

        searchRec(arr, index - 1, key);

    }
}
