package Binary_Trees;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1
// https://www.interviewbit.com/problems/path-to-given-node/

public class Q13_RootToNodePath {
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public ArrayList<Integer> rootToNode(Node root, int B){
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null)
            return path;
        pathFromRoot(root, path, B);
        return path;
    }
    private boolean pathFromRoot(Node node, ArrayList<Integer> path, int x) {
        if (node == null)
            return false;
        path.add(node.data);
        if (node.data == x)
            return true;
        if (pathFromRoot(node.left, path, x) || pathFromRoot(node.right, path, x))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null)
            return paths;
        getPaths(root, path, paths);
        return paths;
    }

    private void getPaths(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        path.add(node.data);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (node.left != null)
            getPaths(node.left, path, paths);
        if (node.right != null)
            getPaths(node.right, path, paths);
        path.remove(path.size() - 1);
    }
}
