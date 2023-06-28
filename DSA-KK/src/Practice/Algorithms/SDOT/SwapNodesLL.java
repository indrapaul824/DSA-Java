package Practice.Algorithms.SDOT;

public class SwapNodesLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head, dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;

            prev = curr;
            curr = curr.next;
        }

        head = dummy.next;
        return head;
    }
}
