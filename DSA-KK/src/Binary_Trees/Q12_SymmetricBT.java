package Binary_Trees;

// https://leetcode.com/problems/symmetric-tree/

public class Q12_SymmetricBT {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isSymmetric(Node root) {
        return root == null || check(root.left, root.right);
    }

    private static boolean check(Node left, Node right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;
        boolean out = check(left.left, right.right);
        boolean in = check(left.right, right.left);

        return (out && in);
    }
}
