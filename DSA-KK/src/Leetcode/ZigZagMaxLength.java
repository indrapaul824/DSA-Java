package Leetcode;
import java.util.*;
public class ZigZagMaxLength {
    /**
     * Definition for a binary tree node.
     */
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    static class Solution {
        static class Triplet {
            TreeNode node;
            int n;
            Boolean left;

            Triplet(TreeNode node, int n, Boolean left) {
                this.node = node;
                this.n = n;
                this.left = left;
            }

        }
        public int longestZigZag(TreeNode root) {
            var st = new ArrayDeque<Triplet>();
            int max = 0;
            st.push(new Triplet(root, 0, null));

            while (!st.isEmpty()) {
                Triplet t = st.pop();
                TreeNode node = t.node;
                int n = t.n;
                Boolean left = t.left;
                if (node != null) {
                    max = Math.max(max, n);
                    st.push(new Triplet(node.left, left != null && !left ? n + 1 : 1, true));
                    st.push(new Triplet(node.right, left != null && left ? n + 1 : 1, false));
                }
            }

            return max;
        }
    }
}
