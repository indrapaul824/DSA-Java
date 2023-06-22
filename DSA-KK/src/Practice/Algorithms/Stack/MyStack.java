package Practice.Algorithms.Stack;

public class MyStack {
    static class Stack {
        private int top;
        private final int size;
        private final int[] arr;

        public Stack(int size) {
            this.size = size;
            top = -1;
            arr = new int[size];
        }

        private void push(int data) {
            if (top >= size) {
                System.out.println("OVERFLOW");
                return;
            }
            arr[++top] = data;
            System.out.println("Element pushed to Stack");
        }

        private int pop() {
            if (top < 0) {
                System.out.println("UNDERFLOW");
                return -1;
            }
            return arr[top--];
        }

        private int getSize() {
            return top + 1;
        }

        private boolean isEmpty() {
            return top < 0;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size is: " + stack.getSize());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
