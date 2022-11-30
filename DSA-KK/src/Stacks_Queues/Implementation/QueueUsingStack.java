package Stacks_Queues.Implementation;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> rev_stack = new Stack<>();

    void insert(int item) {
        while (!stack.isEmpty()) {
            rev_stack.push(stack.pop());
        }
        stack.push(item);
        while (!rev_stack.isEmpty()) {
            stack.push(rev_stack.pop());
        }
    }

    int pop() {
        if (stack.isEmpty())
            return -1;
        return stack.pop();
    }

    int size() {
        return stack.size();
    }

    int peek() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }
}
