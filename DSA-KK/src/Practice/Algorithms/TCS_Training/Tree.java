package Practice.Algorithms.TCS_Training;

public class Tree {
    private Node root;

    Tree() {
        root = null;
    }
    Tree(int val) {
        root = new Node(val);
    }
    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if (root == null)
            return root = new Node(val);

        else if (val < root.val)
            root.left = insertRec(root.left, val);

        else
            root.right = insertRec(root.right, val);

        return root;
    }
}
