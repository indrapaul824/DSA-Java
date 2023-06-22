package Practice.Algorithms.SDOT;

public class IdenticalLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public static boolean isIdentical(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }
}
