package Linked_List;

public class Q1_InsertRec {
    private Node head;

    private void display() {
        Node node = head;

        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    private void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int value, int index, Node node) {
        if (index == 0) {
            return new Node(value, node);
        }

        index--;
        node.next = insertRec(value, index, node.next);
        return node;
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

    public static void main(String[] args) {
        Q1_InsertRec list = new Q1_InsertRec();

        list.insertFirst(8);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(1);
        list.insertFirst(9);

        list.display();

        list.insertRec(100, 3);

        list.display();
    }
}
