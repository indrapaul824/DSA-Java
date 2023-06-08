package Day3_Arrays_III;

public class Q1_Search2DMatrix {
    // GFG - Optimal | Leetcode - Better
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int i = 0, j = m-1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;
            else
                j--;
        }

        return false;
    }

    // Leetcode - Optimal
    public boolean searchMatrix_lcOpt(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = n*m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid/m][mid%m] == target)
                return true;
            else if (matrix[mid/m][mid%m] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
