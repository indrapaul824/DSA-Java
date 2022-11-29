package Linked_List;

public class Q11_ReverseKNodes {
    private ListNode head;
    private int size;
    
    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = null;

        size++;
    }

    ListNode midlleNode(ListNode head) {
        ListNode f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    ListNode reverseList(ListNode node) {
        if (size < 2)
            return node;

        ListNode prev = null, pres = node, next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null)
                next = next.next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        // Skip the first left-1 nodes
        ListNode curr = head;
        ListNode prev = null;

        while (true) {
            ListNode last = prev;
            ListNode newEnd = curr;

            ListNode next = curr.next;

            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null)
                    next = next.next;
            }

            if (last != null)
                last.next = prev;
            else
                head = prev;

            newEnd.next = curr;

            if (curr == null)
                break;

            prev = newEnd;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
    }
}
