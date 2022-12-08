package Stacks_Queues;

import java.util.*;

public class Q6_StockSpan {
    public static int[] stockSpan(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Deque<Map.Entry<Integer, Integer>> stack = new ArrayDeque<>();
        stack.push(Map.entry(arr[0], 0));

        output[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek().getKey() <= arr[i])
                stack.pop();
            if (stack.isEmpty())
                output[i] = i + 1;
            else
                output[i] = i - stack.peek().getValue();
            stack.push(Map.entry(arr[i], i));
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {90, 100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(stockSpan(arr)));
    }
}
