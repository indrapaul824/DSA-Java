package Binary_Trees;

import java.util.*;

public class B2_Traversals {
    static class Node<T extends Comparable<?>> {
        Node<T> left, right;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }


    public static <T extends Comparable<?>> void preOrder(Node<T> node) {
        if (node == null)
            return;

        System.out.print(node.data + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static <T extends Comparable<?>> void inOrder(Node<T> node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " -> ");
        inOrder(node.right);
    }

    public static <T extends Comparable<?>> void postOrder(Node<T> node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " -> ");
    }

    public static <T extends Comparable<?>> List<List<T>> levelOrder(Node<T> node) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        List<List<T>> wrapList = new LinkedList<List<T>>();
        if (node == null)
            return wrapList;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<T> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                assert queue.peek() != null;
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                assert queue.peek() != null;
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(Objects.requireNonNull(queue.poll()).data);
            }
            wrapList.add(subList);
        }

        return wrapList;
    }

    public static <T extends Comparable<?>> List<List<T>> levelOrderSpiral(Node<T> node) {
        Deque<Node<T>> queue = new ArrayDeque<>();
        List<List<T>> wrapList = new LinkedList<List<T>>();
        if (node == null)
            return wrapList;
        queue.offer(node);
        int lv = 0;
        while (!queue.isEmpty()) {
            lv++;
            int levelNum = queue.size();
            List<T> subList = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                if (lv % 2 != 0) {
                    assert queue.peekFirst() != null;
                    if (queue.peekFirst().left != null)
                        queue.offer(queue.peekFirst().left);
                    assert queue.peekFirst() != null;
                    if (queue.peekFirst().right != null)
                        queue.offer(queue.peekFirst().right);
                    subList.add(Objects.requireNonNull(queue.pollFirst()).data);
                }

                else {
                    assert queue.peekLast() != null;
                    if (queue.peekLast().left != null)
                        queue.offer(queue.peekLast().left);
                    assert queue.peekLast() != null;
                    if (queue.peekLast().right != null)
                        queue.offer(queue.peekLast().right);
                    subList.add(Objects.requireNonNull(queue.pollLast()).data);
                }

            }
            wrapList.add(subList);
        }

        return wrapList;
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
    
    public static void main(String[] args) {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.right.left = new Node<>(6);
        root.right.left = new Node<>(7);
        root.right.right = new Node<>(8);
        root.right.right.left = new Node<>(9);
        root.right.right.right = new Node<>(10);

        BTreePrinter.printNode(root);

        System.out.println("Pre-Order Traversal:");
        preOrder(root);

        System.out.println("\nIn-Order Traversal:");
        inOrder(root);

        System.out.println("\nPost-Order Traversal:");
        postOrder(root);

        System.out.println("\nLevel-Order Traversal:");
        List<List<Integer>> levelOrder = levelOrder(root);
        for (List<Integer> list : levelOrder) {
            System.out.print(list + " -> ");
        }

        System.out.println("\nLevel-Order Spiral Traversal:");
        List<List<Integer>> levelOrderSpiral = levelOrderSpiral(root);
        for (List<Integer> list : levelOrderSpiral) {
            System.out.print(list + " -> ");
        }
    }
}
