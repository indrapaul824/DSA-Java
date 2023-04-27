package Stacks_Queues;

// Given an array, print the Next Greater Element (NGE) for every element.
// The Next greater Element for an element x is the first greater element on the right side of x in array.
// Elements for which no greater element exist, consider next greater element as -1.
// https://leetcode.com/problems/next-greater-element-i/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Q2_NGR {
    public static int[] nextGreaterElement(int[] arr, int[] nums) {
        int n = arr.length;
        HashMap<Integer, Integer> output = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty())
                output.put(arr[i], -1);
            else if (stack.peek() > arr[i]) // && !stack.isEmpty()
                output.put(arr[i], stack.peek());
            else {  // if (!stack.isEmpty() && stack.peek() <= arr[i]
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();
                if (stack.isEmpty())
                    output.put(arr[i], -1);
                else
                    output.put(arr[i], stack.peek());
            }
            stack.push(arr[i]);
        }
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = output.get(nums[i]);
        }

        return ans;
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        long[] res = new long[n];
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[] nums = {4, 1, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreaterElement(arr, nums)));
    }
}
