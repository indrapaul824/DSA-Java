package Binary_Trees;
import java.util.*;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1

public class Q17_PrintNodesAtK {
    static class Node {
        Node left, right;
        int data;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static List<Integer> KDistanceNodes(Node root, int t , int k) {
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track);
        Node target = findNode(root, t);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == k)
                break;
            curr_level++;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    queue.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            list.add(curr.data);
        }
        Collections.sort(list);
        return list;
    }

    private static Node findNode(Node root, int t) {
        if (root == null || root.data == t)
            return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.data == t)
                return node;

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return null;
    }

    private static void markParents(Node root, Map<Node, Node> parentTrack) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

}
