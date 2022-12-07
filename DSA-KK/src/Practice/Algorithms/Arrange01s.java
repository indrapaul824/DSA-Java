package Practice.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Arrange01s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int n = in.nextInt();

        System.out.println("Enter the Array elements consisting of 0's and 1's only: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Given Array: " + Arrays.toString(arr));
        arrange0and1(arr, n);
        System.out.println("Arranged Array: " + Arrays.toString(arr));
    }

    public static void arrange0and1(int[] arr, int n) {
        int left = 0, right = n - 1;

        while ( left < right) {
            while (arr[left] == 0 && left < right)
                left++;

            while (arr[right] == 1 && left < right)
                right--;

            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
