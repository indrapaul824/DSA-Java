package Binary_Search_Trees;

public class Q5_FloorBST {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static int floor(Node root, int key) {
        if (root == null) return -1;

        int floor = -1;
        while (root != null) {
            if (root.data == key)
                return key;
            else if (key < root.data) {
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }
}
