package Stacks_Queues;

import java.util.Stack;

public class Q10_MinStack {
    Stack<Long> stack;
    long minElement;

    public Q10_MinStack() {
        stack = new Stack<>();
        minElement = 0;
    }

    public void push(long val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minElement = val;
        }
        else {
            if (val >= minElement)
                stack.push(val);
            else {
                stack.push(2*val - minElement);
                minElement = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        else {
            if (stack.peek() >= minElement)
                stack.pop();
            else
                minElement = 2 * minElement - stack.pop();
        }
    }

    public long top() {
        if (stack.isEmpty())
            return -1;
        else {
            if (stack.peek() >= minElement)
                return stack.peek();
            else
                return minElement;
        }
    }

    public long getMin() {
        if (stack.isEmpty())
            return -1;
        return minElement;
    }
    
    public static void main(String[] args) {
        Q10_MinStack minStack = new Q10_MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483646);
        System.out.println("Top: " + minStack.top());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        minStack.push(2147483646);
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        minStack.push(-2147483646);
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
    }
}
