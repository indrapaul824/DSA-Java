package Practice.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxProdSubArray {
    static class Pair {
        int max;
        ArrayList<Integer> arrayList;

        public Pair(int max, ArrayList<Integer> arrayList) {
            this.max = max;
            this.arrayList = arrayList;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = in.nextInt();
        System.out.println("Enter the array elements: ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Pair pair = maxProd(arr, n);
        System.out.println("The maximum product of a sub-array is: " + pair.max);
        System.out.println("The sub array with max product is: " + pair.arrayList);
    }

    public static Pair maxProd(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0, prod = 1;

        for (int i = 0; i < n; i++) {
            prod *= arr[i];
            if (prod > max) {
                max = prod;
                list.add(arr[i]);
            }

            if (prod == 0) {
                prod = 1;
                list.clear();
            }
        }

        return new Pair(max, list);
    }
}
