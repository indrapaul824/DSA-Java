package Binary_Search_Trees;

public class Q17_LargestBSTinBT {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Check for leaf node
    static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }
    // Post-Order Traversal
    static int[] postOrder(Node root) {
        int[] arr = new int[3];
        if (root == null) {
            arr[0] = 0;
            arr[1] = Integer.MIN_VALUE;
            arr[2] = Integer.MAX_VALUE;
            return arr;
        }

        if (isLeaf(root)) {
            arr[0] = 1;
            arr[1] = root.data;
            arr[2] = root.data;
            return arr;
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        // curr node
        if (root.data > left[1] && root.data < right[2]) {
            int s = 1 + left[0] + right[0];
            int max = Math.max(root.data, Math.max(left[1], right[1]));
            int min = Math.min(root.data, Math.min(left[2], right[2]));
            return new int[]{s, max, min};
        }
        return new int[]{Math.max(left[0], right[0]), Integer.MAX_VALUE, Integer.MIN_VALUE};
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return postOrder(root)[0];
    }
}
