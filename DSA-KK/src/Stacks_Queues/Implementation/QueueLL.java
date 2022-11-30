package Stacks_Queues.Implementation;

public class QueueLL {
    protected QueueNode front = null, rear = null;
    protected int size = 0;

    private static class QueueNode {
        private int val;
        private QueueNode next;

        public QueueNode(int val) {
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.val;
    }

    public void enQueue(int item) {
        QueueNode temp = new QueueNode(item);
        if (front == null)
            front = temp;
        else
            rear.next = temp;

        rear = temp;
        System.out.printf("Element %d inserted into Queue%n", item);
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int removed = front.val;
        front = front.next;
        size--;
        return removed;
    }
    
    public void display() {
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        QueueLL list = new QueueLL();
        list.enQueue(2);
        list.enQueue(34);
        list.enQueue(45);
        list.enQueue(12);
        list.enQueue(89);

        list.display();

        System.out.println(list.deQueue());
        System.out.println(list.deQueue());
        System.out.println(list.deQueue());

        list.display();
    }
}
