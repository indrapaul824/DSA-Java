package Linked_List;

// https://leetcode.com/problems/reverse-linked-list/

public class Q8_ReverseLL {
    private ListNode head;
    private ListNode tail;
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
        if (tail == null) {
            head = tail = new ListNode(val);
            return;
        }
        ListNode node = new ListNode(val, null);
        tail.next = node;
        tail = node;

        size++;
    }

    // Using Recursion
    private void reverse(ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Using in-place Iterative method
    public void reverse() {
        if (size < 2)
            return;

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = head.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null)
                next = next.next;
        }

        head = prev;
    }

    // Neetcode - Good Explanation (https://youtu.be/RF_M9tX4Eag)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // Why dummy? -> If left == 1 -> Then the head of the LL will get reversed, So we need a pointer to the head in this case
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode last = dummy, curr = head;

        // Skip the 1st [left - 1] nodes -> Reach node position at left
        for (int i = 0; i < left-1; i++) {
            last = curr;
            curr = curr.next;
        }

        // Now, curr -> left, last -> node before left
        // Reverse the connections from left to right
        ListNode prev = null;

        // In this case: 1 -> 2 -> 3 -> 4 -> 5 -> NULL ,    left = 2, right = 4
        // We will start from 2 and keep reversing the connections for 3 and then 4
        // A total of 3 times ==> until left[2,3,4] <= right
        while (curr != null && left++ <= right) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Make the new connections with the left and right nodes
        // After reversing, 2 -> NULL 3 -> 2 and 4 -> 3
        // 1    NULL <- 2 <- 3 <- 4     5
        // Connect 1 -> 4 and 2 -> 5
        // Now, prev -> right[4], curr -> node after right[5]
        last.next.next = curr;
        last.next = prev;

        return dummy.next;
    }

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
}
