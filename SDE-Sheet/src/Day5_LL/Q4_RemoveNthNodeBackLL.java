package Day5_LL;

public class Q4_RemoveNthNodeBackLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    // Two-Pass Solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int k = size - n;

        if (k == 0 && head != null)
            return head.next;

        temp = head;
        while (k-- > 1) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // One-Pass Solution
    public ListNode removeNthFromEnd_opt(ListNode head, int n) {
        if (head == null)
            return null;

        // Start both pointers from head
        ListNode slow = head, fast = head;

        // Shift fast pointer to nth node from start
        for (int i = 1; i <= n; i++)
            fast = fast.next;

        // If fast is null -> n == size of LinkedList --> To delete = 1st Node
        // So we update head as ots next value and return
        if (fast == null)
            return head = slow.next;

        // Move the pointers by 1 step until fast reaches the final node
        // At this point, slow will be at the (n-1)th node from end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Connect the (n-1)th node to the (n+1)th node
        slow.next = slow.next.next;

        return head;
    }
}
