package Binary_Trees;

// https://leetcode.com/problems/diameter-of-binary-tree/


public class Q3_DiameterBT {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Naive Approach
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l, r);
    }
    int max = 0;
    void diameter(Node root) {
        if (root == null)
            return;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        max = Math.max(max, lh+rh);

        diameter(root.left);
        diameter(root.right);
    }

    // Optimal Approach
    public int diameterOfBinaryTree(Node root) {
        dia(root);
        return MAX;
    }
    int MAX = 0;
    public int dia(Node root) {
        if (root == null)
            return 0;
        int l = dia(root.left);
        int r = dia(root.right);

        MAX = Math.max(MAX, l+r);

        return 1 + Math.max(l, r);
    }
}
