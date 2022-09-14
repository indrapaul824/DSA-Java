package Linked_List;

public class Singly_LL {

    private Node head;
    private Node tail;

    private int size;

    public Singly_LL() {
        this.size = 0;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
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
            if (node.value == value)
                return node;
            node = node.next;
        }

        return null;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null)
            tail = head;

        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
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

        Node temp = get(index-1);
        temp.next = new Node(val, temp.next);

        size++;
    }

    public int deleteFirst() {
        int deletedElem = head.value;
        head = head.next;

        if (head == null)
            tail = null;

        size--;

        return deletedElem;
    }

    public int deleteLast() {
        if (size <= 1)
            return deleteFirst();

        Node secLast = get(size-2);
        int deletedElem = tail.value;

        tail = secLast;
        tail.next = null;

        size--;

        return deletedElem;
    }

    public int delete(int index) {
        if (index == 0)
            return deleteFirst();
        if (index == size-1)
            return deleteLast();

        Node prev = get(index-1);
        int deletedElem = prev.next.value;

        prev.next = prev.next.next;

        size--;

        return deletedElem;
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
