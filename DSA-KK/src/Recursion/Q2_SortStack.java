package Recursion;

// Q 2 : Sort a stack using recursion

import java.util.Stack;

public class Q2_SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(9);
        stack.push(4);
        stack.push(1);
        stack.push(8);
        stack.push(2);

        sortStack(stack);

        System.out.println(stack);
    }

    static void sortStack(Stack<Integer> stack) {
        
    }
}
