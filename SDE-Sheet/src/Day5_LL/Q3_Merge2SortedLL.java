package Day5_LL;
import java.util.*;

public class Q3_Merge2SortedLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    // Optimal: In-place merging
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)  return list2;
        if (list2 == null)  return list1;

        // To ensure l1 always contains the lowest value, swap if greater
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode result = list1;
        while (list1 != null && list2 != null) {
            ListNode last = null;
            while (list1 != null && list1.val <= list2.val) {
                last = list1;
                list1 = list1.next;
            }

            // condition not fulfilled -> list1 > list2 OR list1 is null
            // so we will remove last -> list1 connection and connect to list2
            last.next = list2;

            // swap list1 <-> list2 since we know list1 > list2
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        return result;
    }
}
