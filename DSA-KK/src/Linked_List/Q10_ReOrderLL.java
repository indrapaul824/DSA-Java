package Linked_List;

// https://leetcode.com/problems/palindrome-linked-list/

public class Q10_ReOrderLL {
    private ListNode head;
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
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = null;

        size++;
    }

    ListNode midlleNode(ListNode head) {
        ListNode f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    ListNode reverseList(ListNode node) {
        if (size < 2)
            return node;

        ListNode prev = null, pres = node, next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null)
                next = next.next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = midlleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // Re-Arrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // Setting next of tail to null
        if (hf != null)
            hf.next = null;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
    }
}
