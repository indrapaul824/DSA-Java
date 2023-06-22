package Practice.Algorithms.Stack;

import java.util.Scanner;

public class Stack {
    private int MAX = 1000;
    private int top;
    private final int[] arr;

    Stack() {
        top = -1;
        arr = new int[MAX];
    }

    Stack(int size) {
        top = -1;
        this.MAX = size;
        arr = new int[size];
    }

    boolean isEmpty() {
        return top < 0;
    }

    void push(int n) {
        if (top >= MAX-1) {
            System.out.println("Stack Overflow");
        }
        else {
            arr[++top] = n;
            System.out.println("The element id pushed into stack");
        }
    }

    int pop () {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return top;
        }

        else
            return arr[top--];
    }

    int size() {
        return top+1;
    }

    int topElement() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return top;
        }

        else
            return arr[top];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                Choices available:
                1. Push an Element into the stack
                2. Pop an element from the stack
                3. Get the current size of the stack
                4. Check if the stack is empty or not
                5. Get the top element of the stack
                (Enter -1 to stop!)
                Your choice is:\040""");

        int n = in.nextInt();
        Stack stack = new Stack();
        while (n != -1) {
            switch (n) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    stack.push(in.nextInt());
                    break;
                case 2:
                    int p = stack.pop();
                    if (p > -1)
                        System.out.println("Element " + p + " was popped from the stack!");
                    break;
                case 3:
                    System.out.println("The current size of the stack is: " + stack.size());
                    break;
                case 4:
                    if (stack.isEmpty())
                        System.out.println("The stack is EMPTY!");
                    else
                        System.out.println("The stack is NOT EMPTY!");
                    break;
                case 5:
                    int a = stack.topElement();
                    if (a > -1)
                        System.out.println("The top element of the stack is: " + a);
                    break;
                default:
                    System.out.println("Enter 1-5 to proceed.");
            }

            System.out.print("""
                Choices available:
                1. Push an Element into the stack
                2. Pop an element from the stack
                3. Get the current size of the stack
                4. Check if the stack is empty or not
                5. Get the top element of the stack
                (Enter -1 to stop!)
                Your choice is:\040""");
            n = in.nextInt();
        }

    }
}
