package Binary_Search_Trees;

public class Q16_RecoverBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node vio1, vio1Next, vio2, prev;
    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && prev.data > root.data) {
            if (vio1 == null) {
                vio1 = prev;
                vio1Next = root;
            }
            else
                vio2 = root;
        }

        prev = root;

        inorder(root.right);
    }
    //Function to fix a given BST where two nodes are swapped.
    public Node recover(Node root)
    {
        inorder(root);

        int t = vio1.data;
        if (vio2 == null) {
            vio1.data = vio1Next.data;
            vio1Next.data = t;
        }
        else {
            vio1.data = vio2.data;
            vio2.data = t;
        }

        return root;
    }
}
