package Practice.Algorithms.SDOT;

public class DoublyLinkedList {
    private Node head;
    int size = 0;
    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node get(int index) {
        Node temp = head;
        while (index-- > 0)
            temp = temp.next;

        return temp;
    }

    private void display() {
        Node temp = head;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private void insertAtHead(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        head.prev = new Node(data, null, head);
        head = head.prev;
        size++;
    }

    private void insertAtTail(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data, temp,null);
        size++;
    }

    private void insert(int data, int pos) {
        if (head == null || pos == 0) {
            insertAtHead(data);
            return;
        }
        if (pos == size-1) {
            insertAtTail(data);
            return;
        }
        Node before = get(pos-1);

        before.next.prev = new Node(data, before, before.next);
        before.next = before.next.prev;

        size++;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(5);
        list.insertAtTail(6);

        list.display();

        list.insertAtHead(0);

        list.display();

        list.insert(3, 3);
        list.insert(4, 4);

        list.display();
    }
}
