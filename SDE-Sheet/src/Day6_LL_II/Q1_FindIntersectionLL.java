package Day6_LL_II;
import java.util.*;

public class Q1_FindIntersectionLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    // Better 1: Hashing
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tempA = headA, tempB = headB;

        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (set.contains(tempB))
                return tempB;
            tempB = tempB.next;
        }

        return null;
    }

    // Better 2:
}
