package Dynamic_Programming.D8_Squares;

// https://leetcode.com/problems/maximal-rectangle/

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1_MaxAreaRectBinary {
    public static int MAH(int[] hist, int n) {
        Deque<Integer> st = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || hist[st.peek()] >= hist[i])) {
                int height = hist[st.pop()];
                int weight;
                if (st.isEmpty())
                    weight = i;
                else
                    weight = i - st.peek() - 1;
                max = Math.max(max, weight*height);
            }
            st.push(i);
        }

        return max;
    }
    public static int maxArea(int[][] M, int n, int m) {
        int maxArea = Integer.MIN_VALUE;
        int[] hist = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1)
                    hist[j]++;
                else
                    hist[j] = 0;
            }
            maxArea = Math.max(maxArea, MAH(hist, m));
        }

        return maxArea;
    }
}
