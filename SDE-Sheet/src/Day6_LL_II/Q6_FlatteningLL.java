package Day6_LL_II;

public class Q6_FlatteningLL {
    public static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    private void mergeTwoSorted(Node l1, Node l2) {
        Node last;
        while (l1 != null && l2 != null) {
            last = null;
            while (l1 != null && l1.data <= l2.data) {
                last = l1;
                l1 = l1.bottom;
            }

            last.bottom = l2;

            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
    }
    public Node flatten(Node root)
    {
        Node list1, list2;

        Node res = root;
        Node dummy = root.next;
        root.next = null;

        while (dummy != null) {
            list1 = res;
            list2 = dummy;
            dummy = list2.next;
            list2.next = null;
            mergeTwoSorted(list1, list2);
        }

        return res;
    }
}
