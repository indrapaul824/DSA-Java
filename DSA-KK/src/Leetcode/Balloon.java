package Leetcode;

import java.util.*;
import utils.Main.*;
public class Balloon {
    public static int findMinArrowShots(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        System.out.println(Arrays.deepToString(points));
        int cnt = 1;
        int prev = 0;
        for (int i = 1; i < points.length; i++) {
            // check if points[prev][1] is within current points[i]
            if (points[i][0] > points[prev][1]) {
                prev = i;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(findMinArrowShots(arr));
    }
}
