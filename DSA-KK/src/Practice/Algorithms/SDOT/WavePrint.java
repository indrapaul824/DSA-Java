package Practice.Algorithms.SDOT;
import utils.Main.*;
import java.util.Arrays;

public class WavePrint {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.next().charAt(0);
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int j = 0; j < m; j++) {
            if (j%2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            else {
                for (int i = n-1; i >= 0; i--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            if (j < n-1)
                System.out.print(" --> ");
        }
    }
}
