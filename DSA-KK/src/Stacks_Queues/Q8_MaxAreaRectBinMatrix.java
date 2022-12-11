package Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q8_MaxAreaRectBinMatrix {

    public static class Pair {
        int height;
        int index;

        public Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    private static int MAH(int[] height) {
        int n = height.length, max = 0;
        int[] area = new int[n];
        Deque<Pair> st = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().height >= height[i])
                st.pop();
            if (st.isEmpty())
                area[i] = n;
            else
                area[i] = st.peek().index;

            st.push(new Pair(height[i], i));
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek().height >= height[i])
                st.pop();
            if (st.isEmpty())
                area[i] *= height[i];
            else
                area[i] = (area[i] - st.peek().index - 1) * height[i];

            if (area[i] > max)
                max = area[i];

            st.push(new Pair(height[i], i));
        }

        return max;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] row = new int[m];

        for (int j = 0; j < m; j++)
            row[j] = Character.getNumericValue(matrix[0][j]);
        int max = MAH(row);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    row[j] = 0;
                else
                    row[j] += Character.getNumericValue(matrix[i][j]);
            }
            max = Math.max(max, MAH(row));
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1', '1', '0'},
                           {'1', '1', '1', '1'},
                           {'1', '1', '1', '1'},
                           {'1', '1', '0', '0'}};

        System.out.println(maximalRectangle(matrix));
    }
}
