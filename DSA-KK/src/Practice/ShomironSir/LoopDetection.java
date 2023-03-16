package Practice.ShomironSir;
import java.util.*;
public class LoopDetection {
    static ListNode head;
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
