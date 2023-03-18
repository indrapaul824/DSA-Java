package Practice.Algorithms.TCS_Training;

import java.util.Scanner;

public class BlockSwapLinkedList {
    private Node head;
    private int size = 0;
    public static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            next = null;
            prev = null;
        }
    }
    void insertTail(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = new Node(val);

        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");

        System.out.println("Size: " + size);
    }

    Node blockSwap(Node head, int k) {
        Node left = head;
        while (k-- > 1)
            left = left.next;
        Node right = left.next;

        left.next = null;
        Node last = right;
        while(last.next != null)
            last = last.next;
        last.next = head;
        head = right;
        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the elements (Enter -1 to end input) : ");
        BlockSwapLinkedList list = new BlockSwapLinkedList();
        int n = in.nextInt();
        while (n != -1) {
            list.insertTail(n);
            n = in.nextInt();
        }
        list.display();
        System.out.print("Enter the block size: ");
        int k = in.nextInt();
        list.head = list.blockSwap(list.head, k);
        list.display();
    }
}
