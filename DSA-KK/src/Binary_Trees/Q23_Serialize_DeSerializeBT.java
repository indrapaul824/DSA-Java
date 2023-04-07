package Binary_Trees;
import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/


public class Q23_Serialize_DeSerializeBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Using an Integer List to store values
    public void serialize(TreeNode root, ArrayList<Integer> A)
    {
        if (root == null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        A.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                A.add(node.left.val);
            }
            else
                A.add(-1);

            if (node.right != null) {
                queue.offer(node.right);
                A.add(node.right.val);
            }
            else
                A.add(-1);
        }
    }

    //Function to deserialize a list and construct the tree.
    public TreeNode deSerialize(ArrayList<Integer> A)
    {
        if (A.size() == 0)
            return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(A.get(0));
        queue.offer(root);
        for (int i = 1; i < A.size(); i++) {
            TreeNode node = queue.poll();
            if (A.get(i) != -1) {
                node.left = new TreeNode(A.get(i));
                queue.offer(node.left);
            }
            if (A.get(++i) != -1) {
                node.right = new TreeNode(A.get(i));
                queue.offer(node.right);
            }
        }

        return root;
    }


    // Using a String to store values
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                A.add(node.left.val);
            }
            else
                A.add(10000);

            if (node.right != null) {
                queue.offer(node.right);
                A.add(node.right.val);
            }
            else
                A.add(10000);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : A) {
            sb.append(i);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        List<Integer> A = Arrays.stream(data.split("\\s")).map(Integer::parseInt).toList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(A.get(0));
        queue.offer(root);
        for (int i = 1; i < A.size(); i++) {
            TreeNode node = queue.poll();
            if (A.get(i) != 10000) {
                node.left = new TreeNode(A.get(i));
                queue.offer(node.left);
            }
            if (A.get(++i) != 10000) {
                node.right = new TreeNode(A.get(i));
                queue.offer(node.right);
            }
        }

        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if (node == null)
            return wrapList;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                assert queue.peek() != null;
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                assert queue.peek() != null;
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(Objects.requireNonNull(queue.poll()).val);
            }
            wrapList.add(subList);
        }

        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(levelOrder(root));
        TreeNode node = deserialize(serialize(root));
        System.out.println(levelOrder(node));

    }
}
