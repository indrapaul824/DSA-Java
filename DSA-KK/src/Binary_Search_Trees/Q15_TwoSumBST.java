package Binary_Search_Trees;
import java.util.*;

public class Q15_TwoSumBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }

    // Optimal Approach

    Stack<TreeNode> n, b;
    int next() {
        TreeNode curr = n.pop();
        int nxt = curr.val;
        curr = curr.right;
        while (curr != null) {
            n.push(curr);
            curr = curr.left;
        }

        return nxt;
    }
    int before() {
        TreeNode curr = b.pop();
        int bef = curr.val;
        curr = curr.left;
        while (curr != null) {
            b.push(curr);
            curr = curr.right;
        }

        return bef;
    }
    public boolean findTarget(TreeNode root, int k) {
        n = new Stack<>();
        b = new Stack<>();

        TreeNode temp = root;
        while (temp != null) {
            n.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            b.push(temp);
            temp = temp.right;
        }

        int i = next(), j = before();
        while (i < j) {
            if (i+j == k)
                return true;
            else if (i+j > k)
                j = before();
            else
                i = next();
        }

        return false;
    }

}
