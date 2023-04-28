package Stacks_Queues;

import java.util.*;

public class Q7_MaxAreaRectHistogram {

    // Brute-Force - O(N^2)
    static int largestarea(int[] arr, int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    // Two-pass Solution - O(N)
    public static class Pair {
        int height;
        int index;

        public Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        int[] area = new int[n];
        Deque<Pair> st = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().height >= heights[i])
                st.pop();
            if (st.isEmpty())
                area[i] = n;
            else
                area[i] = st.peek().index;

            st.push(new Pair(heights[i], i));
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek().height >= heights[i])
                st.pop();
            if (st.isEmpty())
                area[i] = area[i] * heights[i];
            else
                area[i] = (area[i] - st.peek().index - 1) * heights[i];
            if (area[i] > max)
                max = area[i];
            st.push(new Pair(heights[i], i));
        }
        return max;
    }

    // Optimal: One Pass Solution
    public static class PairO {
        long height;
        long index;

        public PairO(long height, long index) {
            this.height = height;
            this.index = index;
        }
    }
    public static long getMaxArea(long[] hist, long n) {
        Deque<PairO> st = new ArrayDeque<>();
        long max = Long.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            while(!st.isEmpty() && (i == n || st.peek().height >= hist[i])) {
                long height = st.pop().height;
                long width;
                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek().index - 1;
                max = Math.max(max, width*height);
            }
            st.push(new PairO((i == n) ? -1 :  hist[i], i));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] h = {6,2,5,4,5,1,6};
        System.out.println(largestRectangleArea(h));
        long[] hist = {6,2,5,4,5,1,6};
        System.out.println(getMaxArea(hist, hist.length));
    }
}
