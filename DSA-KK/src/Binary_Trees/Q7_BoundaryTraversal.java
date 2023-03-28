package Binary_Trees;

// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/0

import java.util.*;

public class Q7_BoundaryTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
             data = d;
             left = right = null;
        }
    }

    ArrayList <Integer> boundary(Node node) {
        ArrayList <Integer> list = new ArrayList<>();
        if (node == null)
            return list;
        if (!isLeaf(node))
            list.add(node.data);
        addLeftBound(node, list);
        addLeaves(node, list);
        addRightBound(node, list);
        return list;
    }

    private void addLeftBound(Node node, ArrayList<Integer> list) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) list.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;

        addLeaves(node.left, list);
        if (isLeaf(node)) list.add(node.data);
        addLeaves(node.right, list);
    }

    private void addRightBound(Node node, ArrayList<Integer> list) {
        Node curr = node.right;
        Stack<Integer> st = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) st.push(curr.data);
            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while (!st.isEmpty())
            list.add(st.pop());
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}
