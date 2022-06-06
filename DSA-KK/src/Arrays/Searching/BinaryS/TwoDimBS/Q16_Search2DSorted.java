package Arrays.Searching.BinaryS.TwoDimBS;

// Q 16 : Search for an element in a strictly sorted matrix

import java.util.Arrays;

public class Q16_Search2DSorted {
    public static void main(String[] args) {
        int[][] mat = { {1,  5,  9,  11},
                        {14, 20, 21, 26},
                        {30, 34, 43, 50} };
        int target = 26;

        System.out.println("The element is found at: Index " + Arrays.toString(search2DSorted(mat, target)));
    }

    public static int[] search2DSorted(int[][] mat, int target) {
        int rows = mat.length, cols = mat[0].length;
        int rStart = 0, rEnd = rows - 1, cMid = cols / 2;

        if (rows == 1)
            return binarySearch(mat, target, 0, 0, cols-1);

        // Run the loop till 2 rows remain
        while (rStart < (rEnd - 1)) { //While this is true, there will be more than 2 remaining rows
            int mid = rStart + (rEnd - rStart) / 2;

            if (mat[mid][cMid] == target)
                return new int[]{mid, cMid};
            else if (mat[mid][cMid] < target)
                rStart = mid;
            else
                rEnd = mid;
        }

        // Now we have 2 rows remaining
        // Check for target in the column of 2 rows
        if (mat[rStart][cMid] == target)
            return new int[]{rStart, cMid};
        else if (mat[rStart+1][cMid] == target)
            return new int[]{rStart+1, cMid};

        // Search in 1st half
        else if (target <= mat[rStart][cMid-1])
            return binarySearch(mat, target, rStart, 0, cMid-1);

        // Search in 2nd half
        else if (target >= mat[rStart][cMid+1] && target <= mat[rStart][cols - 1])
            return binarySearch(mat, target, rStart, cMid+1, cols-1);

        // Search in 3rd half
        else if (target >= mat[rStart+1][cMid-1])
            return binarySearch(mat, target, 0, 0, cMid-1);

        // Search in 4th half
        else if (target >= mat[rStart+1][cMid+1] && target <= mat[rStart+1][cols - 1])
            return binarySearch(mat, target, rStart+1, cMid+1, cols-1);
        else
            return new int[]{-1, -1};
    }

    public static int[] binarySearch(int[][] mat, int target, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if (mat[row][mid] == target)
                return new int[]{row, mid};
            else if (mat[row][mid] < target)
                cStart = mid + 1;
            else
                cEnd = mid - 1;
        }

        return new int[]{-1, -1};
    }
}
