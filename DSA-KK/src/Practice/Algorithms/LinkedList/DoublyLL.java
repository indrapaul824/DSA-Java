package Algorithms.LinkedList;

public class DoublyLL {

    private Node head;
    private int size;

    public void display() {
        Node temp = head;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");

        System.out.println("The size of the Doubly Linked List is: " + size);
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        size++;
    }

    public void insertLast(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node node = new Node(val, null, null);
        Node last = head;

        while (last.next != null)
            last = last.next;

        last.next = node;
        node.prev = last;

        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertHead(val);
            return;
        }

        else if (index == size - 1) {
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;

        while (index > 1) {
            temp = temp.next;
            index--;
        }

        node.next = temp.next;

        if (temp.next != null)
            temp.next.prev = node;

        node.prev = temp;
        temp.next = node;

        size++;
    }

    public static class Node {
        int val;
        Node next;
        Node prev;

        Node () {};
        Node (int val) {
            this.val = val;
        }

        Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();

        list.insertHead(3);
        list.insertHead(5);
        list.insertHead(9);
        list.display();

        list.insertLast(8);
        list.insertLast(4);
        list.insertLast(99);
        list.display();

        list.insert(20, 3);
        list.insert(100, 5);
        list.display();
    }
}
