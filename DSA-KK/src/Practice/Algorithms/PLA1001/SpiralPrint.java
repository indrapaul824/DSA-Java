package Practice.Algorithms.PLA1001;

import java.util.*;

public class SpiralPrint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int n = s.nextInt();

        System.out.println("Enter the matrix elements: ");
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        System.out.println("The matrix is: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%10s", arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nThe spiral traversal of the matrix is: ");
        spiralPrint(arr, n);
    }

    public static void spiralPrint(int[][] arr, int N) {
        int n = N, m = N, l = 0, k = 0, i;

        while (k < n && l < m) {
            for (i = l; i < m; ++i)
                System.out.print(arr[k][i] + " ");
            k++;

            for (i = k; i < n; ++i)
                System.out.print(arr[i][m - 1] + " ");
            m--;

            if (k < n) {
                for (i = m - 1; i >= l; --i)
                    System.out.print(arr[n - 1][i] + " ");
                n--;
            }

            if (l < m) {
                for (i = n - 1; i >= k; --i)
                    System.out.print(arr[i][l] + " ");
                l++;
            }
        }
    }
}
