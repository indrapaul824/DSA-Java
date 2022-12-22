package Practice.Algorithms.GreedyAlgo;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the num of elements:");
        int n = in.nextInt();
        int[] start = new int[n], end = new int[n];
        System.out.println("Enter the Start Array elements:");
        // 7 9 2 6 3 5
        for (int i = 0; i < n; i++)
            start[i] = in.nextInt();
        System.out.println("Enter the End Array elements:");
        // 1 3 6 4 5 9
        for (int i = 0; i < n; i++)
            end[i] = in.nextInt();
        bubbleSort(end, start, n);
        System.out.println(Arrays.toString(end));
        System.out.println(Arrays.toString(start));
        greedyPrint(start, end, n);
    }

    public static void bubbleSort(int[] end, int[] start, int n) {
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (end[j] > end[j + 1]) {
                    swap(end, j, j + 1);
                    swap(start, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    private static void swap(int[] end, int j, int i) {
        int temp = end[j];
        end[j] = end[i];
        end[i] = temp;
    }

    public static void greedyPrint(int[] start, int[] end, int n) {
        System.out.println("The Greedy Traversal of the Array is: ");
        System.out.printf("%d : %d%n", 0, start[0]);
        for (int i = 1, j = 0; i < n; i++) {
            if (start[i] >= end[j]) {
                System.out.printf("%d : %d%n", i, start[i]);
                j = i;
            }
        }
    }
}
