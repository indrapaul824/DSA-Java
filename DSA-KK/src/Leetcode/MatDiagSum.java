package Leetcode;

public class MatDiagSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int j1 = 0, j2 = mat[0].length-1;
        for (int i = 0; i < mat.length && j1 < mat[0].length && j2 >= 0; i++) {
            sum += mat[i][j1] + mat[i][j2];
            if (j1 == j2)
                sum -= mat[i][j1];
            j1++;
            j2--;
        }
        return sum;
    }
}
