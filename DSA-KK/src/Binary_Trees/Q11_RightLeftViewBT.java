package Binary_Trees;
import java.util.*;

// https://leetcode.com/problems/binary-tree-right-side-view/

public class Q11_RightLeftViewBT {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<>();
        revPreOrder(root, 0, list);
        return list;
    }

    private void revPreOrder(Node node, int level, List<Integer> list) {
        if (node == null)
            return;

        if (level == list.size())
            list.add(node.data);

        revPreOrder(node.right, level+1, list);
        revPreOrder(node.left, level+1, list);
    }
}
