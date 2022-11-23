package Linked_List;

public class Q6_MidLL {

    private ListNode head;

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void insert(int val) {

        if (head == null) {
            head = new ListNode(val);
            return;
        }

        ListNode temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = new ListNode(val, null);
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/
    public int midElement(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        if (s != null)
            return s.val;

        return -1;
    }


    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public void deleteMiddle(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode f = head;
        ListNode s = head;

        while (f.next.next != null && f.next.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        s.next = s.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Q6_MidLL list = new Q6_MidLL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.display();

        System.out.println("The middle element is: " + list.midElement(list.head));

        list.deleteMiddle(list.head);

        System.out.println("The list after the Mid element is deleted: ");
        list.display();
    }
}
