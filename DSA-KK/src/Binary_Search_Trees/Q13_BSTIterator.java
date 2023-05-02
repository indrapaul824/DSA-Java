package Binary_Search_Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    // Approach 1: InOrder store and traverse
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

class BSTIt {
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
    // Approach 2: Optimal using BST
    Stack<TreeNode> st;
    public BSTIt(TreeNode root) {
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        int data = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
        }
        return data;
    }

    public boolean hasNext() {
        return (!st.isEmpty());
    }
}
