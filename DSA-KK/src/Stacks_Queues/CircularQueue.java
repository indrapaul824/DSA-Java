package Stacks_Queues;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int rear = 0, front = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length; // top is at last index
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert (int item) {
        if (isFull())
            return false;

        data[rear++] = item;
        rear = rear % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front () throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        return data[front];
    }

    public void display() throws Exception {
        System.out.println("\nThe queue is:");
        int i = front;
        do {
            System.out.print(data[i] + ", ");
            i++;
            i %= data.length;
        } while (i != rear);
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);

        queue.display();

        queue.insert(6);
        queue.insert(10);
        queue.insert(90);
        queue.insert(74);
        queue.insert(40);

        queue.display();

        System.out.println("The front element is: " + queue.front());
        System.out.println("Removed: " + queue.remove());
        queue.display();

        queue.insert(99);

        queue.display();
    }    
}
