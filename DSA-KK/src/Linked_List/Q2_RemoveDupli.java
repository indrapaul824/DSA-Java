package Linked_List;

// Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Q2_RemoveDupli {

    private ListNode head;

    private void display() {
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDupli(ListNode head) {
        if (head == null)
            return null;

        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Q2_RemoveDupli list = new Q2_RemoveDupli();

        list.insertFirst(3);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);

        list.display();

        ListNode head = list.head;
        head = list.deleteDupli(head);

        list.display();
    }
}
