package Practice.Algorithms.BinarySearchTree;

import java.util.Scanner;

public class CountSubTrees {

    private Node root;

    CountSubTrees() {
        root = null;
    }

    CountSubTrees(int val) {
        root = new Node(val);
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
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

    private static boolean inRange(Node root, int low, int high) {
        return root.val >= low && root.val <= high;
    }

    static class INT {
        int a;
    }
    private static boolean getCount(Node root, int low, int high, INT count) {
        if (root == null)
            return true;

        boolean l = getCount(root.left, low, high, count);
        boolean r = getCount(root.right, low, high, count);

        if (l && r && inRange(root, low, high)) {
            ++count.a;
            return true;
        }

        return false;
    }

    static INT count(Node root, int low, int high) {
        INT count = new INT();
        count.a = 1;
        getCount(root, low, high, count);
        return count;
    }

    public static void main(String[] args) {
        CountSubTrees tree = new CountSubTrees();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Tree Nodes(-1 to stop):");
        int n = in.nextInt();

        while ( n != -1) {
            tree.insert(n);
            System.out.println("Enter the Tree Nodes(-1 to stop):");
            n = in.nextInt();
        }

        System.out.println("Enter the lower and higher range: ");
        int low = in.nextInt(), high = in.nextInt();

        System.out.println("The number of subtrees in the given range are: " + count(tree.root, low, high).a);
    }

}
