package Stacks_Queues.Implementation;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if (this.isFull()) {
            // Double the Array Size
            int[] temp = new int[data.length * 2];

            // Copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            rear = data.length;

            data = temp;
            System.out.println("Size increased!");
        }

        return super.insert(item);
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new DynamicQueue(5);

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

        queue.insert(4);
        queue.display();
        queue.insert(39);
        queue.display();
    }
}
