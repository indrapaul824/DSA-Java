package Binary_Trees;

import java.util.*;

public class Q6_ZigZagTraversalBT {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean LtoR = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                assert node != null;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                if (LtoR)
                    l.add(node.val);
                else
                    l.add(0, node.val);
            }
            LtoR = !LtoR;
            list.add(l);
        }

        return list;
    }
}
