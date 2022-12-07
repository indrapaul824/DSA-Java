package Practice.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MountainArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();


        System.out.println(convertMountainEfficient(arr, n));

        System.out.println(convertMountain(arr, n));
    }

    public static ArrayList<Integer> convertMountain(int[] arr, int n) {
        Arrays.sort(arr);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i%2 != 0)
                right.add(arr[i]);
            else
                left.add(arr[i]);
        }

        Collections.reverse(right);

        left.addAll(right);

        return left;
    }

    public static ArrayList<Integer> convertMountainEfficient(int[] arr, int n) {
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();

        for (int i = 0; i < n/2; i++) {
            right.add(arr[i]);
        }
        for (int i = n/2; i < n; i++) {
            left.add(arr[i]);
        }

        Collections.sort(right);
        left.sort(Collections.reverseOrder());

        right.addAll(left);

        return right;
    }
}
