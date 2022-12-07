package Algorithms.LinkedList;

import java.util.*;

public class SinglyLL {

    private Node head;
    private int size;

    public void insertHead(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }

        head = new Node(val, head);
        size++;
    }

    public void insertLast(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val, null);
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0)
            insertHead(val);
        else if (index == size - 1)
            insertLast(val);

        else if (index > 0 && index < size-1) {
            Node temp = head;

            while (index > 1) {
                temp = temp.next;
                index--;
            }
            temp.next = new Node(val, temp.next);
            size++;
        }

        else
            System.out.println("Invalid Index");
    }

    public boolean checkVal(int val) {
        Node temp = head;

        while (temp != null) {
            if (temp.val == val)
                return true;
            temp = temp.next;
        }

        return false;
    }

    public void appendNoDupli(int val) {
        if (!checkVal(val))
            insertLast(val);
    }

    public void display() {
        Node temp = head;
        System.out.print("\nThe Linked List is: ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");

        System.out.println("The size of the LinkedList is: " + size);
    }

    public static class Node {
        int val;
        Node next;

        Node () {}

        Node (int val) {
            this.val = val;
        }

        Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the LinkedList elements: ");
        int n = in.nextInt();
        SinglyLL list = new SinglyLL();
        while (n != -1) {
            list.insertLast(n);
            n = in.nextInt();
        }

        list.display();

        System.out.print("\nInsert at a specific position[0-based indexing]? (Y/N): ");
        String c = in.next();
        if (c.equals("y") || c.equals("Y")) {
            System.out.println("Enter the value and the index:");
            System.out.print("Value: ");
            int v = in.nextInt();
            System.out.print("Index: ");
            int i = in.nextInt();
            list.insert(v, i);
            list.display();
        }

        System.out.print("\nInsert by checking duplicates? (Y/N): ");
        c = in.next();
        if (c.equals("y") || c.equals("Y")) {
            System.out.println("Enter the values:");
            n = in.nextInt();
            while (n != -1) {
                list.appendNoDupli(n);
                n = in.nextInt();
            }
            list.display();
        }
    }
}
