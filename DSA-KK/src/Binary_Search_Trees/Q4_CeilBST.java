package Binary_Search_Trees;

public class Q4_CeilBST {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int findCeil(Node root, int key) {
        if (root == null) return -1;

        int ceil = -1;
        while (root != null) {
            if (root.data == key)
                return key;
            else if (key < root.data) {
                ceil = root.data;
                root = root.left;
            }
            else
                root = root.right;
        }

        return ceil;
    }
}
