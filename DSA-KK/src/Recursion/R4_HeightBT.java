package Recursion;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class R4_HeightBT {

    Node root;

    R4_HeightBT() {
        root = null;
    }
    R4_HeightBT(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        R4_HeightBT tree = new R4_HeightBT();

        // create root
        tree.root = new Node(1);
        /* Tree looks like:

                1
             /    \
           null   null
         */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null
      */

        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
          /   \
        null  null
         */

        System.out.println(height(tree.root));
    }

    static int height(Node root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return (1 + Math.max(lh, rh));
    }
}
