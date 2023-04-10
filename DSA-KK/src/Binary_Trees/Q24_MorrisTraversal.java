package Binary_Trees;
import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal/

public class Q24_MorrisTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // InOrder Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // Case 1 -> No left
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            }

            // Case 2 -> Left Exists
            else {
                TreeNode prev = curr.left;
                // Traverse to the rightmost node of Left SubTree
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                // Case 1: Node->Right is null
                if (prev.right == null) {
                    // Create a thread
                    prev.right = curr;
                    // Move left
                    curr = curr.left;
                }
                // Case 2: Node->Right is not null --> Means that a thread os present to curr
                else {
                    // Remove the thread
                    prev.right = null;
                    // Thread present -> curr is root now
                    inorder.add(curr.val);
                    // Move right
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }


    // PreOrder Morris Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // Case 1 -> No left
            if (curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            }

            // Case 2 -> Left Exists
            else {
                TreeNode prev = curr.left;
                // Traverse to the rightmost node of Left SubTree
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                // Case 1: Node->Right is null
                if (prev.right == null) {
                    // Create a thread
                    prev.right = curr;
                    // Thread creates -> that means curr is root
                    preorder.add(curr.val);
                    // Move left
                    curr = curr.left;
                }
                // Case 2: Node->Right is not null --> Means that a thread os present to curr
                else {
                    // Remove the thread
                    prev.right = null;
                    // Move right
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }
}
