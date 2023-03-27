package Binary_Trees;

// https://leetcode.com/problems/balanced-binary-tree/

public class Q2_HeightBalancedBT {
    static class Node
    {
        int data;
        Node left,right;

        Node(int d)
        {
            data = d;
            left = right = null;
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
    boolean check(Node root) {
        if (root == null)
            return true;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if (Math.abs(lh - rh) > 1)
            return false;

        boolean left = check(root.left);
        boolean right = check(root.right);

        return left && right;
    }

    // Optimal Approach
    public int dfsH(Node root) {
        if (root == null)
            return 0;

        int l = dfsH(root.left);
        if (l == -1)
            return -1;

        int r = dfsH(root.right);
        if (r == -1)
            return -1;

        if (Math.abs(l - r) > 1)
            return -1;

        return 1 + Math.max(l, r);
    }

    public boolean isBalanced(Node root) {
        return dfsH(root) != -1;
    }
}
