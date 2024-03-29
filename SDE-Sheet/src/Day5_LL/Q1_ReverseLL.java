package Day5_LL;

public class Q1_ReverseLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    // Iterative
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive
    private ListNode reverse(ListNode head, ListNode prev) {
        if (head == null)
            return prev;

        ListNode next = head.next;
        head.next = prev;
        return reverse(next, head);
    }
    public ListNode reverseList_rec(ListNode head) {
        return reverse(head, null);
    }
}
