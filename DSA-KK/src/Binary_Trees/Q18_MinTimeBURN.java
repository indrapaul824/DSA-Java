package Binary_Trees;
import java.util.*;

// https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563
// https://practice.geeksforgeeks.org/problems/burning-tree/1

public class Q18_MinTimeBURN {
    static class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int minTime(Node root, int target) {
        if (root == null)
            return 0;
        Node t = findNode(root, target);
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.offer(t);
        visited.put(t, true);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    flag = 1;
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    flag = 1;
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                if (parent_track.get(node) != null && !visited.containsKey(parent_track.get(node))) {
                    flag = 1;
                    queue.offer(parent_track.get(node));
                    visited.put(parent_track.get(node), true);
                }
            }
            // Increment the level only if some node has been burnt
            if (flag == 1) level++;
        }

        return level;
    }

    private static void markParents(Node root, Map<Node, Node> parentTrack) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                parentTrack.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                parentTrack.put(node.right, node);
            }
        }
    }

    private static Node findNode(Node root, int target) {
        if (root == null || root.data == target)
            return root;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.data == target)
                return node;
            
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        
        return null;
    }
}
