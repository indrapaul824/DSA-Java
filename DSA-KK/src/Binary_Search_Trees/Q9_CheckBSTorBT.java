package Binary_Search_Trees;
// https://leetcode.com/problems/validate-binary-search-tree/

public class Q9_CheckBSTorBT {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
     static boolean solve(Node root, long low, long high) {
        if (root == null)
            return true;

        if (root.data <= low || root.data >= high)
            return false;

        else if (root.data > low && root.data < high && solve(root.left, low, root.data))
            return solve(root.right, root.data, high);

        return false;
    }
    public boolean isValidBST(Node root) {
        long low = Long.MIN_VALUE;
        long high = Long.MAX_VALUE;

        return solve(root, low, high);
    }
}
