package Linked_List;

public class Circular_LL {
    private Node head;
    private Node tail;
    private int size;

    public Circular_LL() {
        this.head = null;
        this.tail = null;
    }

    public void display() {
        Node node = head;

        if (head != null) {
            System.out.print("HEAD -> ");
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    public  void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;

        size++;
    }

    public void delete(int val) {
        Node node = head;

        if (node == null)
            return;

        if (node.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        while (node.next.value != val) {
            node = node.next;
            if (node == head)
                return;
        }

        node.next = node.next.next;

        size--;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
