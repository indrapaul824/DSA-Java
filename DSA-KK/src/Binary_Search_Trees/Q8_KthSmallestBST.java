package Binary_Search_Trees;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class Q8_KthSmallestBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int cnt;
    static int ans;

    public static void solve(Node root, int k) {
        if (root == null)
            return;

        solve(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.data;
            return;
        }
        solve(root.right, k);
    }
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        cnt = 0;
        ans = -1;
        solve(root, k);
        return ans;
    }
}
