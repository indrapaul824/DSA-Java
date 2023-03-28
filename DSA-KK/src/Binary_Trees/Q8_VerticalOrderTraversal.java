package Binary_Trees;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/0

import java.util.*;

public class Q8_VerticalOrderTraversal {
    static class Node {
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Tuple {
        Node node;
        int row;
        int col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    static List<List<Integer>> verticalOrder(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> Q = new ArrayDeque<>();
        Q.offer(new Tuple(root, 0, 0));
        while (!Q.isEmpty()) {
            Tuple tuple = Q.poll();
            Node node = tuple.node;

            int x = tuple.row;
            int y = tuple.col;
            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            if (node.left != null)
                Q.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                Q.offer(new Tuple(node.right, x + 1, y + 1));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    System.out.print(nodes.peek() + " ");
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
            System.out.println();
        }

        return list;
    }

    static class Pair {
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    static List<Integer> verticalOrder_gfg(Node root) {
         ArrayList<Integer> ans = new ArrayList<>();
         if (root == null)
             return ans;

         Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
         Queue<Pair> Q = new ArrayDeque<>();
         Q.offer(new Pair(0, root));
         while (!Q.isEmpty()) {
             Pair pair = Q.poll();
             Node node = pair.node;
             int row = pair.hd;
             if (map.containsKey(row))
                 map.get(row).add(node.data);
             else {
                  ArrayList<Integer> temp=new ArrayList<>();
                  temp.add(node.data);
                  map.put(row, temp);
             }
             if (node.left != null)
                 Q.offer(new Pair(row - 1, node.left));
             if (node.right != null)
                 Q.offer(new Pair(row + 1, node.right));
         }
         for (Map.Entry<Integer, ArrayList<Integer>> hm : map.entrySet())
             ans.addAll(hm.getValue());

         return ans;
    }
}
