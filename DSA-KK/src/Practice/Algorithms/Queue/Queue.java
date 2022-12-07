package Algorithms.Queue;

import java.util.Scanner;

public class Queue {
    public static int front, rear, capacity;
    public static int queue[];

    Queue (int c) {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    boolean isFull (int[] queue) {
        return (rear == capacity);
    }

    boolean isEmpty (int[] queue) {
        return (front == rear);
    }

    void enqueue (int item) {
        if (isFull(queue)) {
            System.out.println("\nQueue");
            return;
        }
        queue[rear] = item;
        rear++;
    }

    int dequeue () {
        if (isEmpty(queue)) {
            System.out.println("\nQueue is Empty\n");
            return Integer.MIN_VALUE;
        }

        int item = queue[front];
        front++;
        return item;
    }

    int front () {
        if (isEmpty(queue)) {
            System.out.println("\nQueue is Empty\n");
            return Integer.MIN_VALUE;
        }

        return queue[front];
    }

    int rear () {
        if (isEmpty(queue)) {
            System.out.println("\nQueue is Empty\n");
            return Integer.MIN_VALUE;
        }

        return queue[rear - 1];
    }

    void printQueue () {
        if (isEmpty(queue)) {
            System.out.println("\nQueue is Empty\n");
            return;
        }

        System.out.println("\nQueue is: ");

        for (int i = front; i < rear; i++) {
            System.out.println(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue queue  = new Queue(100);

        System.out.println("Enter the queue elements(-1 to stop): ");
        int n = in.nextInt();
        while (n != -1) {
            queue.enqueue(n);
            n = in.nextInt();
        }
        queue.printQueue();


    }
}
