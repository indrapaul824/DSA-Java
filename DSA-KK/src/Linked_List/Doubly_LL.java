package Linked_List;

public class Doubly_LL {

    private Node head;

    private int size;

    public Doubly_LL() {
        this.size = 0;
    }

    public void display() {
        Node node = head;
        Node last = null;

        System.out.println("Actual Order(Using Node.next):");
        System.out.print("NULL <-> ");
        while (node != null) {
            System.out.print(node.value + " <-> ");
            last = node;
            node = node.next;
        }
        System.out.println("NULL");

        System.out.println("Reverse Order(Using Node.prev):");
        System.out.print("NULL <-> ");
        while (last != null) {
            System.out.print(last.value + " <-> ");
            last = last.prev;
        }
        System.out.println("NULL");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        size++;
    }

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node (int value) {
            this.value = value;
        }

        public Node (int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
