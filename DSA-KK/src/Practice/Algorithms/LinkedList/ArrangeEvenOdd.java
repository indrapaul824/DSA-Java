package Practice.Algorithms.LinkedList;
import utils.Main.*;
public class ArrangeEvenOdd {

    private int size;
    private Node head;

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
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

    public static class Node {
        int val;
        Node next;

        Node () {}
        Node (int val) {
            this.val = val;
        }
    }

    void arrangeEvenOdd() {
        Node temp = head;
        Node even = null, odd = null, evenHead = null, oddHead = null;

        while (temp != null) {
            if (temp.val % 2 == 0) {
                if (even == null) {
                    even = temp;
                    evenHead = even;
                }
                else {
                    even.next = temp;
                    even = even.next;
                }
            }
            else {
                if (odd == null) {
                    odd = temp;
                    oddHead = odd;
                }
                else {
                    odd.next = temp;
                    odd = odd.next;
                }
            }
            temp = temp.next;
        }

        if (even != null)
            even.next = oddHead;

        if (odd != null)
            odd.next = null;

        head = evenHead;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        System.out.println("Enter the LinkedList elements: ");
        int n = in.nextInt();
        ArrangeEvenOdd list = new ArrangeEvenOdd();
        while (n != -1) {
            list.insert(n);
            n = in.nextInt();
        }

        list.display();

        list.arrangeEvenOdd();

        list.display();
    }
}
