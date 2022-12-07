package Algorithms.Stack;

import java.util.Scanner;

public class StackLL {

    private StackNode root;

    private static class StackNode {
        private int val;
        private StackNode next;

        StackNode (int val) {
            this.val = val;
        }
    }

    boolean isEmpty() {
        return root == null;
    }

    void push (int n) {
        StackNode node = new StackNode(n);
        if (root == null) {
            root = node;
            return;
        }

        StackNode temp = root;
        root = node;
        node.next = temp;

        System.out.println(n + " is pushed to the Stack!");
    }

    int pop () {
        if (root == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int n = root.val;
        root = root.next;

        return n;
    }

    int size() {
        if (root == null)
            return 0;

        StackNode temp = root;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    int topElement() {
        if (root == null) {
            System.out.println("The Stack is EMPTY!");
            return -1;
        }
        return root.val;
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
        StackLL stack = new StackLL();
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
