package Stacks_Queues.Implementation;

public class Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int rear = 0;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return rear == data.length; // top is at last index
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public boolean insert (int item) {
        if (isFull())
            return false;

        data[rear++] = item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        int removed = data[0];

        for (int i = 1; i < rear; i++) {
            data[i-1] = data[i];
        }
        data[rear-1] = 0;
        rear--;

        return removed;
    }

    public int front () throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        return data[0];
    }

    public void display() {
        System.out.println("\nThe queue is:");
        for (int i : data)
            System.out.print(i + ", ");
        System.out.println("END\n");
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);

        queue.display();

        queue.insert(6);
        queue.insert(10);
        queue.insert(90);
        queue.insert(74);
        queue.insert(40);
        queue.insert(3);

        queue.display();

        System.out.println("The front element is: " + queue.front());
        System.out.println("Removed: " + queue.remove());
        queue.display();
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());

        queue.display();
    }
}
