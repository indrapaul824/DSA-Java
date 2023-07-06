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

    // Better 2: Difference in Length
    private int getDiff(ListNode tempA, ListNode tempB) {
        int size1 = 0, size2 = 0;

        // Calculate the Length of each List
        while (tempA != null || tempB != null) {
            if (tempA != null) {
                size1++;
                tempA = tempA.next;
            }
            if (tempB != null) {
                size2++;
                tempB = tempB.next;
            }
        }

        return size1 - size2;
    }

    public ListNode getIntersectionNode_b2(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;

        // Find the larger list and the absolute difference between them
        int diff = getDiff(temp1, temp2);

        // Shifting the larger list diff times to bring them to the same level | If diff == 0 -> no need to shift
        if (diff > 0) {
            // ListA is longer
            while (diff-- != 0)  temp1 = temp1.next;
        }
        else if (diff < 0) {
            // ListB is longer
            while (diff++ != 0)  temp2 = temp2.next;
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }

    // Optimal: Using difference but reverting to head when node==null until two are equal
    public ListNode getIntersectionNode_op(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1 == null ? headA : temp1.next;
            temp2 = temp2 == null ? headB : temp2.next;
        }

        return temp1;
    }
}
