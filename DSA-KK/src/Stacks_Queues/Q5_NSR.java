package Stacks_Queues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Q5_NSR {
    public static int[] nextLesserElement(int[] arr, int[] nums) {
        int n = arr.length;
        HashMap<Integer, Integer> output = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty())
                output.put(arr[i], -1);
            else if (stack.peek() < arr[i]) // && !stack.isEmpty()
                output.put(arr[i], stack.peek());
            else {  // if (!stack.isEmpty() && stack.peek() <= arr[i]
                while (!stack.isEmpty() && stack.peek() >= arr[i])
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

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextLesserElement(arr, nums)));
    }
}
