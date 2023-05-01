package Binary_Search_Trees;

public class Q12_InOrderSuccPredBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Res {
        Node pre = null;
        Node succ = null;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        Node succ = null, pre = null;
        Node temp = root;

        while (temp != null) {
            if (key >= temp.data) {
                temp = temp.right;
            }
            else {
                succ = temp;
                temp = temp.left;
            }
        }

        while (root != null) {
            if (key <= root.data) {
                root = root.left;
            }
            else {
                pre = root;
                root = root.right;
            }
        }

        p.pre = pre;
        s.succ = succ;
    }

    // Recursive Way
    static void findSucc(Node root, Res s, int key) {
        if (root == null)
            return;
        if (key >= root.data)
            findSucc(root.right, s, key);
        else {
            s.succ = root;
            findSucc(root.left, s, key);
        }
    }

    static void findPre(Node root, Res p, int key) {
        if (root == null)
            return;
        if (key <= root.data)
            findPre(root.left, p, key);
        else {
            p.pre = root;
            findPre(root.right, p, key);
        }
    }

    public static void findPreSuc_rec(Node root, Res p, Res s, int key)
    {
        if (root == null)
            return;
        findSucc(root, s, key);
        findPre(root, p, key);
    }
}
