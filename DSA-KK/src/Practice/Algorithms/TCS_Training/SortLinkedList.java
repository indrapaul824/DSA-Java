package Practice.Algorithms.TCS_Training;

import java.util.Scanner;

public class SortLinkedList {
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
        System.out.print("NULL -> ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");

        System.out.println("Size: " + size);
    }

    Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        // Cut LL into 2 halves
        Node fast = head, slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Sort both the halves
        Node left = mergeSort(head);
        Node right = mergeSort(slow);

        // Merge the two LLs
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node l = new Node(0), p = l;
         while (left != null && right != null) {
             if (left.val < right.val) {
                 p.next = left;
                 left = left.next;
             }
             else {
                 p.next = right;
                 right = right.next;
             }
             p = p.next;
         }
         if (left != null)
             p.next = left;
         if (right != null)
             p.next = right;

         return l.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the elements for L1 (Enter -1 to end input) : ");
        SortLinkedList list1 = new SortLinkedList();
        SortLinkedList list2 = new SortLinkedList();
        int n = in.nextInt();
        while (n != -1) {
            list1.insertTail(n);
            n = in.nextInt();
        }
        System.out.print("Enter the elements for L2 (Enter -1 to end input) : ");
        n = in.nextInt();
        while (n != -1) {
            list2.insertTail(n);
            n = in.nextInt();
        }
        System.out.println("List 1: ");
        list1.display();
        System.out.println("List 2: ");
        list2.display();

        Node temp = list1.head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = list2.head;
        list1.size = list1.size + list2.size;

        list1.display();

        list1.head = list1.mergeSort(list1.head);

        list1.display();
    }
}
