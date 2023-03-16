package Practice.ShomironSir;

import java.util.*;
import utils.Main.*;
public class RemoveDuplicates {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node() {
            next = null;
        }
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private void display() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void removeDup() {
        Node curr = head;
        Node prev = null;
        Set<Integer> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            }
            else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        RemoveDuplicates list = new RemoveDuplicates();
        int n = in.nextInt();
        while (n != -1) {
            list.insertFirst(n);
            n = in.nextInt();
        }
        list.display();
        list.removeDup();
        list.display();
    }
}
