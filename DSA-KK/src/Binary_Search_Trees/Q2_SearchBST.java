package Binary_Search_Trees;
// https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1

public class Q2_SearchBST {

    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static boolean search(Node root, int x) {
        Node temp = root;
        while (temp != null) {
            if (temp.data == x)
                return true;
            else if (x < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
        }

        return false;
    }

    static boolean search_rec(Node root, int x) {
        if (root == null || root.data == x)
            return true;
        return x < root.data ? search_rec(root.left, x) : search_rec(root.right, x);
    }
}
