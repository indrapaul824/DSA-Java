package Binary_Trees;

import java.util.Scanner;

public class B1_Intro {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public static void inOrder(Node temp) {
        if (temp == null)
            return;

        inOrder(temp.left);
        System.out.print(temp.data + " -> ");
        inOrder(temp.right);
    }

    public Node buildTree() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == -1)
            return null;

        root = new Node(n);
        root.left = buildTree();
        root.right = buildTree();

        return root;
    }

    public static void main(String[] args) {
        B1_Intro tree = new B1_Intro();

        tree.root = tree.buildTree();

        inOrder(tree.root);
    }
}
