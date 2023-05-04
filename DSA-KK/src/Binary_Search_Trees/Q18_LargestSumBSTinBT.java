package Binary_Search_Trees;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class Q18_LargestSumBSTinBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans = 0;
    boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    int[] postOrder(TreeNode root) {
        if (root == null)
            return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};

        else if (isLeaf(root))
            return new int[]{root.val, root.val, root.val};

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        if (root.val > left[1] && root.val < right[2]) {
            int sum = root.val + left[0] + right[0];
            int max = Math.max(root.val, Math.max(left[1], right[1]));
            int min = Math.min(root.val, Math.min(left[2], right[2]));
            ans = Math.max(ans, sum);
            return new int[]{sum, max, min};
        }
        int s = Math.max(left[0], right[0]);
        ans = Math.max(ans, s);
        return new int[]{s, Integer.MAX_VALUE, Integer.MIN_VALUE};
    }

    public int maxSumBST(TreeNode root) {
        int res = postOrder(root)[0];
        return ans;
    }
}
