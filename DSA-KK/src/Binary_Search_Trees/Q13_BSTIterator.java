package Binary_Search_Trees;

import java.util.ArrayList;
import java.util.List;

public class Q13_BSTIterator {
    public static class TreeNode {
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
    List<Integer> list = new ArrayList<>();
    int curr;
    public Q13_BSTIterator(TreeNode root) {
        curr = -1;
        inorder(root, list);
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int next() {
        return list.get(++curr);
    }

    public boolean hasNext() {
        return (curr+1) < list.size();
    }
}
