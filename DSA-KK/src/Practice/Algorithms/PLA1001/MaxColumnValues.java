package Practice.Algorithms.PLA1001;

import java.util.Arrays;
import java.util.Scanner;

public class MaxColumnValues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n = in.nextInt();
        System.out.println("Enter the matrix elements: ");
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println("The matrix is: ");
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        System.out.println();

        for (int i = 0; i < n; i++) {
            int max = matrix[0][i];
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] > max)
                    max = matrix[j][i];
            }
            System.out.printf("The Max of Column %d is: %d%n", i+1, max);
        }
    }
}
