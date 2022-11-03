package Linked_List;

// Given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one sorted list.
// The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
// https://leetcode.com/problems/merge-two-sorted-lists/

public class Q3_MergeTwoLists {

    private ListNode head;

    public void display() {
        ListNode node = head;

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null) {
            return list1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Q3_MergeTwoLists list1 = new Q3_MergeTwoLists();
        Q3_MergeTwoLists list2 = new Q3_MergeTwoLists();

        list1.insert(3);
        list1.insert(2);
        list1.insert(1);
        list2.insert(9);
        list2.insert(5);
        list2.insert(3);
        list2.insert(1);

        list1.display();
        list2.display();

        ListNode h = mergeTwoLists(list1.head, list2.head);

        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.println("NULL");
    }
}
