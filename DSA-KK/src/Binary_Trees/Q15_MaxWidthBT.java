package Binary_Trees;
import java.util.*;



public class Q15_MaxWidthBT {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static class Pair {
        Node node;
        int num;

        public Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        Q.offer(new Pair(root, 0));
        while (!Q.isEmpty()) {
            int size = Q.size();
            int min = Q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int cur_id = Q.peek().num - min;
                Node node = Q.poll().node;

                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;

                if (node.left != null)
                    Q.offer(new Pair(node.left, cur_id * 2 + 1));
                if (node.right != null)
                    Q.offer(new Pair(node.right, cur_id * 2 + 2));
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}
