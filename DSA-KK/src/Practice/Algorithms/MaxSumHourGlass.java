package Practice.Algorithms;

import utils.Main.*;
import java.util.ArrayList;

public class MaxSumHourGlass {
    public static int maxSum(int[][] arr, int row, int col) {
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < row - 2; i++) {
            int sum = 0;
            for (int j = 0; j < col - 2; j++) {
                sum  = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = j;
                }
            }
        }
        int i = start, j = end;
        System.out.println(arr[i][j] + " " + arr[i][j+1] + " " + arr[i][j+2] + "\n   " + arr[i+1][j+1] + "\n" + arr[i+2][j] + " " + arr[i+2][j+1] + " " + arr[i+2][j+2]);
        return max;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int row = in.nextInt(), col = in.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(maxSum(arr, row, col));
    }
}
