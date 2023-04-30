package Binary_Search_Trees;
// https://leetcode.com/problems/delete-node-in-a-bst/

public class Q7_DeleteNodeBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode delete(TreeNode root) {
        // Edge Case
        if (root.left == null && root.right == null)
            return null;
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        // Both left and right present
        TreeNode rightMost = findRightmost(root.left);
        rightMost.right = root.right;
        return root.left;
    }

    public static TreeNode findRightmost(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root;
    }

    public static TreeNode searchAndDelete(TreeNode oRoot, TreeNode root, int key) {
        if (root == null)
            return oRoot;

        // Base Case
        if (root.left != null && root.left.val == key) {
            root.left = delete(root.left);
            return oRoot;
        }
        else if (root.right != null && root.right.val == key) {
            root.right = delete(root.right);
            return oRoot;
        }

        if (key > root.val)
            return searchAndDelete(oRoot, root.right, key);
        else
            return searchAndDelete(oRoot, root.left, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key)
            return delete(root);

        return searchAndDelete(root, root, key);
    }
}
