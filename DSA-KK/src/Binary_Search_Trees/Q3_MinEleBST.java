package Binary_Search_Trees;
// https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1

public class Q3_MinEleBST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    int minValue(Node node) {
        while (node != null) {
            if (node.left != null)
                node = node.left;
            else
                return node.data;
        }
        return -1;
    }

    int minValue_rec(Node node) {
        if (node == null)
            return -1;
        if (node.left == null)
            return node.data;
        return minValue_rec(node.left);
    }
}
