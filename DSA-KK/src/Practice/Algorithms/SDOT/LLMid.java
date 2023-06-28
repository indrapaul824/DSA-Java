package Practice.Algorithms.SDOT;

public class LLMid {
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

    public ListNode middleNode_opti(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode middleNode_brute(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        if (size % 2 == 0)
            size--;
        size /= 2;
        while (size-- > 0)
            temp = temp.next;

        return temp;
    }
}
