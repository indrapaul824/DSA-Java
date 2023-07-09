package Day6_LL_II;

// https://leetcode.com/problems/palindrome-linked-list/solutions/1137027/js-python-java-c-easy-floyd-s-reversal-solution-w-explanation/

public class Q4_PalindromeLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode midlleNode(ListNode head) {
        ListNode f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    private ListNode reverseList(ListNode node) {
        if (node == null)
            return node;

        ListNode prev = null, pres = node;

        while (pres != null) {
            ListNode next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;

        ListNode mid = midlleNode(head);
        ListNode headSec = reverseList(mid);
        ListNode rereverseHead = headSec;

        // Compare both the halves
        while (head != null && headSec != null) {
            if (head.val != headSec.val)
                return false;
            head = head.next;
            headSec = headSec.next;
        }

        return true;
    }
}
