package Practice.Algorithms.SDOT;
import utils.Main.*;

public class MaxParking01 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int r = in.nextInt(), c = in.nextInt();
        int[][] pklot = new int[r][c];
        int max = 0, maxI = 0;
        for (int i = 0; i < r; i++) {
            int cnt = 0;
            for (int j = 0; j < c; j++) {
                pklot[i][j] = in.nextInt();
                if (pklot[i][j] == 1)
                    cnt++;
            }
            if (cnt > max) {
                max = cnt;
                maxI = i;
            }
        }

        System.out.println("The row in the parking lot with the most spaces: " + (maxI+1));
    }
}
