package Binary_Trees;
import java.util.*;

public class Q16_ChildrenSumProp {
    static class Node<T extends Comparable<?>> {
        Node<T> left, right;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }
    
    static class BTreePrinter {

        public static <T extends Comparable<?>> void printNode(Node<T> root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<Node<T>> newNodes = new ArrayList<>();
            for (Node<T> node : nodes) {
                if (node != null) {
                    System.out.print(node.data);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println();

            for (int i = 1; i <= endgeLines; i++) {
                for (Node<T> node : nodes) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (node == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (node.left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (node.right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println();
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }

    // Brute Force Approach
    // TC: O(N^2)
    // SC: O(H)
    public static void convertTree(Node<Integer> node) {
        int left = 0, right = 0, diff;
        
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        else {
            convertTree(node.left);
            convertTree(node.right);
            
            if (node.left != null)
                left = node.left.data;
            if (node.right != null)
                right = node.right.data;
            
            diff = left + right - node.data;
            
            if (diff > 0)
                node.data += diff;
            
            if (diff < 0)
                increment(node, -diff);
        }
    }

    private static void increment(Node<Integer> node, int diff) {
        if (node.left != null) {
            node.left.data += diff;
            increment(node.left, diff);
        }
        else if (node.right != null) {
            node.right.data += diff;
            increment(node.right, diff);
        }
    }

    // Optimal Approach
    // TC: O(N)
    // SC: O(H)
    public static void convertTree_opt(Node<Integer> node) {
        if (node == null)
            return;

        int child = 0;
        if (node.left != null)
            child += node.left.data;
        if (node.right != null)
            child += node.right.data;

        if (child >= node.data)
            node.data = child;
        else {
            if (node.left != null)
                node.left.data = node.data;
            if (node.right != null)
                node.right.data = node.data;
        }

        int tot = 0;
        if (node.left != null)
            tot += node.left.data;
        if (node.right != null)
            tot += node.right.data;
        if (node.left != null || node.right != null)
            node.data = tot;
    }

    //Function to check whether all nodes of a tree have the value equal to the sum of their child nodes.
    public static int isSumProperty(Node<Integer> node)
    {
        if (node == null || (node.left == null && node.right == null))
            return 1;

        int left = 0, right = 0;

        if (node.left != null)
            left = node.left.data;
        if (node.right != null)
            right = node.right.data;

        if ((node.data == left + right) && isSumProperty(node.left) == 1 && isSumProperty(node.right) == 1)
            return 1;
        else
            return 0;

    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(50);
        root.left = new Node<>(7);
        root.right = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(1);
        root.right.right = new Node<>(30);

        System.out.println("Original Tree:");
        BTreePrinter.printNode(root);

        convertTree(root);

        System.out.println("Converted Tree following Children-Sum Property:");
        BTreePrinter.printNode(root);

        convertTree_opt(root);

        System.out.println("Converted Tree following Children-Sum Property:");
        BTreePrinter.printNode(root);
    }
}
