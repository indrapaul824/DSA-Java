package Practice.Algorithms.TCS_Training;

import java.util.Scanner;

public class TrendyLinkedList {
    private Node head;
    private static int size = 0;
    public static class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
            next = null;
        }
    }
    void insertHead(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
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

    boolean checkTrendy(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int k = cnt / 2;
        temp = head;
        while (k-- > 1) {
            temp = temp.next;
        }
        if (cnt % 2 == 0) {
            return (temp.val + temp.next.val) % 3 == 0;
        }
        return temp.val % 3 == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TrendyLinkedList list = new TrendyLinkedList();
        System.out.print("Enter the elements (Enter -1 to end input) : ");
        int n = in.nextInt();
        while (n != -1) {
            list.insertHead(n);
            n = in.nextInt();
        }
        list.display();
        System.out.println((list.checkTrendy(list.head) ? "Trendy List" : "Not a Trendy List"));
    }
}
