package Linked_List;

public class Q7_SortList {

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

    public void bubbleSort() {

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

    public static void main(String[] args) {

    }
}
