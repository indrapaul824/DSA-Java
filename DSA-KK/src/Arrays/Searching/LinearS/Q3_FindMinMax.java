package Arrays.Searching.LinearS;

// Q 3 : Find minimum and maximum number in an array

import java.util.Arrays;

public class Q3_FindMinMax {
    public static void main(String[] args) {
        int[] arr = {18, 87, 12, 45, -9, 4, 28, 93, 74};
        System.out.println(Arrays.toString(showMinMax(arr)));
    }

    public static int[] showMinMax(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return new int[]{-1};
        }
        int max = arr[0], min = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            } else if (item < min) {
                min = item;
            }
        }
        System.out.println("The max item is: " + max);
        System.out.println("The min item is: " + min);

        return new int[]{max, min};
    }
}
