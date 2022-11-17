package Linked_List;

// https://leetcode.com/problems/reverse-linked-list/

public class Q8_ReverseLL {
    private ListNode head;
    private ListNode tail;
    private int size;

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void insert(int val) {
        if (tail == null) {
            head = tail = new ListNode(val);
            return;
        }
        ListNode node = new ListNode(val, null);
        tail.next = node;
        tail = node;

        size++;
    }

    // Using Recursion
    private void reverse(ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Using in-place Iterative method
    public void reverse() {
        if (size < 2)
            return;

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = head.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null)
                next = next.next;
        }

        head = prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        // Skip the 1st left - 1 nodes
        ListNode prev = null, pres = head;

        for (int i = 0; head != null && i < left - 1; i++) {
            prev = pres;
            pres = pres.next;
        }

        ListNode last = prev, newEnd = pres;

        // Reverse between left and right
        ListNode next = pres.next;
        for (int i = 0; pres != null && i < right-left+1; i++) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null)
                next = next.next;
        }

        if (last != null)
            last.next = prev;
        else
            head = prev;

        newEnd.next = pres;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
