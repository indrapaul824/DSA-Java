package Day6_LL_II;

public class Q3_ReverseInGroupKLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge Cases
        if (head == null || head.next == null || k <= 1)
            return head;

        // Calculate the size of the LL
        int size = getSize(head);
        if (size < k)
            return head;

        // Create a dummy node -> head
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode last = dummy;

        ListNode prev = last, curr = head;

        // Number of Groups to reverse = size / k
        for (int i = 0; i < size/k; i++) {
            // Reverse k nodes
            for (int j = 0; curr != null && j < k; j++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Storing the initial 1st node of the group
            ListNode temp = last.next;

            // Update the front and end connections
            last.next.next = curr;
            last.next = prev;

            // Update the pointers for next group
            last = temp;
            prev = new ListNode();
            prev.next = curr;
        }

        return dummy.next;
    }
}
