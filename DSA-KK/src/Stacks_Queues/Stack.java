package Stacks_Queues;

public class Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int top = -1;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        this.data = new int[size];
    }

    public boolean push (int item) {
        if (isFull()) {
            System.out.println("Stack is Full!");
            return false;
        }
        data[++top] = item;
        return true;
    }

    public int pop () throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot POP from an empty stack");
        }

        return data[top--];
    }

    public int peek () throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot PEEK from an empty stack");
        }

        return data[top];
    }

    public boolean isFull() {
        return top == data.length - 1; // top is at last index
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) throws StackException {
        Stack stack = new Stack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
