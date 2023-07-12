package Day6_LL_II;

public class Q5_StartPointLoopLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        int flag = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = 1;
                break;
            }
        }

        if (flag == 0)
            return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
