package Arrays.Searching.LinearS;

import java.util.Arrays;

public class Q4_Search2D {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };
        int target = 56;

        System.out.println(Arrays.toString(search2D(arr, target)));
        System.out.println(Arrays.toString(dimMinMax(arr)));
    }

    public static int[] search2D(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] dimMinMax(int[][] arr) {
        int max = arr[0][0], min = arr[0][0];

        for (int[] row : arr) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                } else if (num < min) {
                    min = num;
                }
            }
        }

        System.out.println("The max and min values are: " + max + ", " + min);
        return new int[]{max, min};
    }
}
