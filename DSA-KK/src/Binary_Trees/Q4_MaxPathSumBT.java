package Binary_Trees;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Q4_MaxPathSumBT {
    static class Node {
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    static int findMaxSum(Node node) {
        maxSum(node);
        return max;
    }
    static int max = Integer.MIN_VALUE;
    static int maxSum(Node node) {
        if (node == null)
            return 0;
        int lh = Math.max(0, maxSum(node.left));
        int rh = Math.max(0, maxSum(node.right));

        max = Math.max(max, node.data + lh + rh);

        return node.data + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.right.left = new Node(-15);
        root.right.right = new Node(-30);

        System.out.println(findMaxSum(root));
    }
}
