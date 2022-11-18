package Linked_List;

// https://leetcode.com/problems/palindrome-linked-list/

public class Q9_PalindromeLL {
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

    public boolean isPalindrome(ListNode head) {
        ListNode mid = midlleNode(head);
        ListNode headSec = reverseList(mid);
        ListNode rereverseHead = headSec;

        // Compare both the halves
        while (head != null && headSec != null) {
            if (head.val != headSec.val)
                break;
            head = head.next;
            headSec = headSec.next;
        }

        reverseList(rereverseHead);

        return head == null || headSec == null;
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
