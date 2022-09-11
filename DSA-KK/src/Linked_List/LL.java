package Linked_List;

public class LL{

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size = 0;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null)
            tail = head;

        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size-1) {
            insertLast(val);
            return;
        }

        Node temp = head;

        for (int i=1; i<index; i++) {
            temp = temp.next;
        }
        temp.next = new Node(val, temp.next);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;

        }
    }
}
