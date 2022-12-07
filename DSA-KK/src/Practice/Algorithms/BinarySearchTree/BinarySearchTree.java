package Algorithms.BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int val) {
        root = new Node(val);
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        else if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    public int getMin() {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }

        return node.val;
    }

    static int count = 0;
    public Node getKthMin(Node root, int n) {
        if (root == null)
            return null;

        Node left = getKthMin(root.left, n);

        if (left != null)
            return left;

        count++;
        if (count == n)
            return root;

        return getKthMin(root.right, n);
    }


    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Tree Nodes(-1 to stop):");
        int n = in.nextInt();

        while ( n != -1) {
            tree.insert(n);
            System.out.println("Enter the Tree Nodes(-1 to stop):");
            n = in.nextInt();
        }

        System.out.printf("The min element is: %d%n", tree.getMin());

        System.out.println("Enter the position: ");
        int m = in.nextInt();
        System.out.printf("The %dth min element is: %d", m, tree.getKthMin(tree.root, m).val);
    }
}
