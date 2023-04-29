package Binary_Search_Trees;
// https://leetcode.com/problems/insert-into-a-binary-search-tree


public class Q6_InsertNodeBST {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int Key) {
        if (root == null)
            return new Node(Key);

        if (Key < root.data)
            root.left = insert(root.left, Key);
        else if (Key > root.data)
            root.right = insert(root.right, Key);

        return root;
    }
}
