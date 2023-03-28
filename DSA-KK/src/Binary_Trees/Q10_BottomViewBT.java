package Binary_Trees;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

public class Q10_BottomViewBT {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class Pair {
        Node node;
        int ln;

        public Pair(Node node, int ln) {
            this.node = node;
            this.ln = ln;
        }
    }

    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> Q = new ArrayDeque<>();
        Q.offer(new Pair(root, 0));
        while (!Q.isEmpty()) {
            Pair temp = Q.poll();
            int line = temp.ln;

            map.put(line, temp.node.data);

            if (temp.node.left != null)
                Q.offer(new Pair(temp.node.left, line - 1));

            if (temp.node.right != null)
                Q.offer(new Pair(temp.node.right, line + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            list.add(entry.getValue());

        return list;
    }
}
