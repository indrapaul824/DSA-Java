package Day2_Arrays_II;

public class Q1_RotateMatrix {
    private void swap(int[][] matrix, int i, int j, int n_i, int n_j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n_i][n_j];
        matrix[n_i][n_j] = temp;
    }

    // Rotate Clock-wise direction
    private void reverse(int[][] matrix, int row) {
        int start = 0, end = matrix.length-1;
        while (start < end) {
            swap(matrix, row, start, row, end);
            start++;
            end--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the given matrix
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Reverse every row of the matrix
        for (int i = 0; i < n; i++) {
            reverse(matrix, i);
        }
    }

    // Rotate Anti-clockwise direction
    private void reverse_anti(int[][] matrix, int col) {
        int start = 0, end = matrix.length-1;
        while (start < end) {
            swap(matrix, start, col, end, col);
            start++;
            end--;
        }
    }
    public void rotate_anti(int[][] matrix)
    {
        int n = matrix.length;
        // Transpose the given matrix
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Reverse every col of the matrix
        for (int i = 0; i < n; i++) {
            reverse(matrix, i);
        }
    }
}
