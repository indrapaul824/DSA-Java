package Day1_Arrays_I;

public class Q1_SetMatrixZeroes {
    // Better Approach
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[] row = new int[n], col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }

    // Optimal Approach
    public void setZeroes_optimal(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // row[i] = 1;
                    matrix[i][0] = 0;

                    // col[j] = 1;
                    if (j > 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // Check for row and col
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
            }
        }

        // 1st Row - dependant on matrix[0][0]
        if (matrix[0][0] == 0) {
            for (int j = 1; j < m; j++)
                matrix[0][j] = 0;
        }

        // 1st Col - dependant on col0
        if (col0 == 0) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
    }
}
