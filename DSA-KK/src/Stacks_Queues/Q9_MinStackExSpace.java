package Stacks_Queues;

import java.util.Stack;

public class Q9_MinStackExSpace {
    Stack<Integer> S;
    Stack<Integer> SS;

    public Q9_MinStackExSpace() {
        S = new Stack<>();
        SS = new Stack<>();
    }

    public void push(int val) {
        S.push(val);

        if (SS.isEmpty() || SS.peek() >= val)
            SS.push(val);

        System.out.println("Pushed: " + val);
    }

    public void pop() {
        if (S.isEmpty())
            return;
        int ans = S.pop();
        if (SS.peek() == ans)
            SS.pop();
        System.out.println("Popped: " + ans);
    }

    public int top() {
        return S.peek();
    }

    public int getMin() {
        if (SS.isEmpty())
            return -1;
        return SS.peek();
    }

    public static void main(String[] args) {
        Q9_MinStackExSpace minStack = new Q9_MinStackExSpace();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
    }
}
