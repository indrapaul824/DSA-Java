package Stacks_Queues;

import java.util.*;

public class Q4_NSL {
    public static int[] previousLesserElement(int[] arr, int[] nums) {
        int n = arr.length;
        HashMap<Integer, Integer> output = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty())
                output.put(i, -1);
            else if (stack.peek() < i) // && !stack.isEmpty()
                output.put(i, stack.peek());
            else {  // if (!stack.isEmpty() && stack.peek() >= arr[i]
                while (!stack.isEmpty() && stack.peek() >= i)
                    stack.pop();
                if (stack.isEmpty())
                    output.put(i, -1);
                else
                    output.put(i, stack.peek());
            }
            stack.push(i);
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
        System.out.println(Arrays.toString(previousLesserElement(arr, nums)));
    }
}
