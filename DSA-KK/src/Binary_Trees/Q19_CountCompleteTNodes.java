package Binary_Trees;

public class Q19_CountCompleteTNodes {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = getLH(root);
        int right = getRH(root);

        if (left == right)
            return (2 << left) - 1;

        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getLH(TreeNode root) {
        int cnt = 0;
        while (root.left != null) {
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    public static int getRH(TreeNode root) {
        int cnt = 0;
        while (root.right != null) {
            cnt++;
            root = root.right;
        }
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}
