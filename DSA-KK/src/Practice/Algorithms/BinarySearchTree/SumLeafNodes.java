package Algorithms.BinarySearchTree;

import java.util.Scanner;

public class SumLeafNodes {
    private Node root;
    static int sum;
    
    SumLeafNodes() {
        root = null;
        sum = 0;
    }
    
    SumLeafNodes(int val) {
        root = new Node(val);
        sum = 0;
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
        else 
            root.right = insertRec(root.right, val);
        
        return root;
    }

    private void preorderSum(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null)
            sum = sum + node.val;

        preorderSum(node.left);
        preorderSum(node.right);
    }

    public int sumLeaf() {
        preorderSum(root);
        return sum;
    }

    public static class Node {
        int val;
        Node left, right;
        
        Node (int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        SumLeafNodes tree = new SumLeafNodes();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Tree Nodes(-1 to stop):");
        int n = in.nextInt();

        while ( n != -1) {
            tree.insert(n);
            System.out.println("Enter the Tree Nodes(-1 to stop):");
            n = in.nextInt();
        }

        System.out.println("The sum of leaf nodes is: " + tree.sumLeaf());
    }
}
