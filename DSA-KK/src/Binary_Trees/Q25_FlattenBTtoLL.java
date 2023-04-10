package Binary_Trees;
import java.util.*;

public class Q25_FlattenBTtoLL {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    // Recursion
    Node prev = null;
    public void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    // Iterative (Stack)
    public void flatten_it(Node root) {
        if (root == null)
            return;
        var st = new ArrayDeque<Node>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.poll();
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);

            if (!st.isEmpty())
                curr.right = st.peek();
            curr.left = null;
        }
    }

    // Morris Traversal Concept
    public void flatten_mt(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                Node prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}
