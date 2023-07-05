package Day5_LL;

public class Q5_Add2NumLL {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
        }

        return newHead.next;
    }

    // Solution for GFG or Foolo-up
    // If Linked List representatiom was not reversed
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    private static Node reverse(Node head) {
        Node curr = head, prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    //Function to add two numbers represented by linked list.
    public static Node addTwoLists(Node first, Node second){
        // Reverse both list to start from their Least Significant Digit
        first = reverse(first);
        second = reverse(second);

        // Compute the addition
        Node newHead = new Node(0);
        Node temp = newHead;

        int carry = 0;

        while (first != null || second != null || carry != 0) {
            int sum = 0;

            if (first != null) {
                sum += first.data;
                first = first.next;
            }

            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            sum += carry;
            carry = sum / 10;

            temp.next = new Node(sum % 10);
            temp = temp.next;
        }

        // Since the computed addition is also in reverse -> reverse the result

        newHead = reverse(newHead.next);

        return newHead;
    }
}
