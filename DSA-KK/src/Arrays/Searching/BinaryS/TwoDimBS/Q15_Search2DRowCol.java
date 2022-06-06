package Arrays.Searching.BinaryS.TwoDimBS;

// Q 15 : Search for an element in a row-wise and column-wise sorted matrix
// The matrix is sorted both ways
// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

import java.util.Arrays;

public class Q15_Search2DRowCol {
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};
        int target = 29;

        System.out.println("The element is present at: Index " + Arrays.toString(search2DRowCol(mat, target)));
    }

    public static int[] search2DRowCol(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int i = 0, j = m - 1;

        while (i>=0 && i<n && j>=0 && j<m) {
            int mid = mat[i][j];

            if (mid == target)
                return new int[]{i, j};
            else if (mid > target)
                j--;
            else
                i++;
        }

        return new int[]{-1, -1};
    }
}
