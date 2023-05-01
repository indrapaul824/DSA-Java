package Binary_Search_Trees;
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

public class Q11_ContructBSTPreOrder {
    static class Node {
        int val;
        Node left, right;
        public Node(int d) {
            val = d;
            left = right = null;
        }
    }
    static int i;
    static Node solve(int ub, int[] preorder) {
        if (i == preorder.length || preorder[i] > ub)
            return null;

        Node root = new Node(preorder[i++]);

        root.left = solve(root.val, preorder);
        root.right = solve(ub, preorder);

        return root;
    }
    public Node bstFromPreorder(int[] preorder) {
        int ub = Integer.MAX_VALUE;
        i = 0;
        return solve(ub, preorder);
    }
}
