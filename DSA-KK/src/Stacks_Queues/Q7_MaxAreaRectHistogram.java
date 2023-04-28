package Stacks_Queues;

import java.util.*;

public class Q7_MaxAreaRectHistogram {

    // Two-pass Solution
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

    public static void main(String[] args) {
        int[] h = {6,2,5,4,5,1,6};
        System.out.println(largestRectangleArea(h));
    }
}
