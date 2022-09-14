package Linked_List;

// Create a linked list of size N by inserting the given input literals to a new empty List from both sides.
// https://practice.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0

import java.util.*;

class Node {
    int data;
    Node next;

    Node (int x) {
        data = x;
        next = null;
    }
}

public class Q1_Insertion {
    static void printList(Node node) {
        while (node != null) {
            System.out.println(node.data + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Function to insert a node at the beginning of the linked list
    static Node insertAtBeginning(Node head, int x)
    {
        Node node = new Node(x);
        node.next = head;
        head = node;

        return head;
    }

    // Function to insert a node at the end of the linked list.
    static Node insertAtEnd(Node head, int x)
    {
        Node temp = new Node(x);
        if(head == null) {
            return temp;
        }

        Node curr = head;

        while (curr.next != null)
            curr = curr.next;

        curr.next = temp;
        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            Node head = null;
            for (int i=0; i<n; i++) {
                int value = in.nextInt();
                int indicator = in.nextInt();

                if (indicator == 0)
                    head = insertAtBeginning(head, value);
                else
                    head = insertAtEnd(head, value);
            }

            printList(head);
            t--;
        }
    }
}
