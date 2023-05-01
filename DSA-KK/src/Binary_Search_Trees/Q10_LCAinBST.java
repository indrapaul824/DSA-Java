package Binary_Search_Trees;

public class Q10_LCAinBST {
    static class Node {
        int val;
        Node left, right;
        public Node(int d) {
            val = d;
            left = right = null;
        }
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || p.val == root.val || q.val == root.val)
            return root;

        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
