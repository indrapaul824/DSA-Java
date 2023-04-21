package Practice.Algorithms.SDOT;
import utils.Main.*;

public class ArrangeEvenOdd {
    private Node head;
    int size = 0;
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    void insert(int n) {
        Node node = new Node(n);

        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = null;

        size++;
    }

    void arrangeEvenOdd() {
        Node temp = head;
        Node even = null, odd = null, evenH = null, oddH = null;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (even == null) {
                    even = temp;
                    evenH = even;
                }
                else {
                    even.next = temp;
                    even = even.next;
                }
            }

            else {
                if (odd == null) {
                    odd = temp;
                    oddH = odd;
                }
                else {
                    odd.next = temp;
                    odd = odd.next;
                }
            }
            temp = temp.next;
        }

        if (odd != null)
            odd.next = evenH;

        if (even != null)
            even.next = null;

        head = oddH;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        ArrangeEvenOdd list = new ArrangeEvenOdd();
        int n = in.nextInt();
        while (n != -1) {
            list.insert(n);
            n = in.nextInt();
        }

        list.display();

        list.arrangeEvenOdd();

        list.display();
    }
}
