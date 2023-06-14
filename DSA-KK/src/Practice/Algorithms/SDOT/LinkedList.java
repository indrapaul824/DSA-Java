package Practice.Algorithms.SDOT;

public class LinkedList {
    private Node head;
    int size = 0;
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node get(int index) {
        Node node = head;

        for (int i=0; i < index; i++)
            node = node.next;

        return node;
    }

    public Node find(int value) {
        Node node = head;

        while (node != null) {
            if (node.data == value)
                return node;
            node = node.next;
        }

        return null;
    }

    private void insertAtHead(int data) {
        head = new Node(data, head);
        size++;
    }

    private void insertAtTail(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
        size++;
    }

    private void insert(int data, int pos) {
        if (head == null || pos == 0)
            insertAtHead(data);
        else if (pos == size-1)
            insertAtTail(data);
        else {
            if (pos > size) {
                System.out.println("Invalid Position");
                return;
            }
            Node temp = head;
            while (pos-- > 1)
                temp = temp.next;
            temp.next = new Node(data, temp.next);
            size++;
        }
    }

    private int deleteAtStart() {
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    private int deleteAtEnd() {
        if (size <= 1)
            deleteAtStart();

        Node secLast = get(size-2);
        int val = secLast.data;
        secLast.next = null;
        size--;
        return val;
    }

    private int delete(int pos) {
        if (size <= 1 || pos == 0)
            deleteAtStart();
        if (pos == size-1)
            deleteAtEnd();

        Node prev = get(pos - 1);
        int val = prev.next.data;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    private void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.insertAtHead(40);

        list.insertAtTail(1);
        list.insertAtTail(0);

        list.insert(4, 0);
        list.insert(100, 4);

        list.display();

        System.out.println(list.deleteAtStart());
        System.out.println(list.deleteAtEnd());
        System.out.println(list.delete(3));

        list.display();
    }
}
