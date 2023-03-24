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
    public static <T extends Comparable<?>> void preOrder_it(Node<T> node) {
        if (node == null)
            return;
        Stack<Node<T>> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node<T> top = st.pop();
            System.out.print(top.data + " -> ");
            if (top.right != null)
                st.push(top.right);
            if (top.left != null)
                st.push(top.left);
        }
    }

    public static <T extends Comparable<?>> void inOrder(Node<T> node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " -> ");
        inOrder(node.right);
    }
    public static <T extends Comparable<?>> void inOrder_it(Node<T> root) {
        if (root == null)
            return;
        Stack<Node<T>> st = new Stack<>();
        Node<T> node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            }
            else {
                if (st.isEmpty())
                    break;
                node = st.pop();
                System.out.print(node.data + " -> ");
                node = node.right;
            }
        }
    }

    public static <T extends Comparable<?>> void postOrder(Node<T> node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " -> ");
    }
    public static <T extends Comparable<?>> void postOrder_it1(Node<T> node) {
        if (node == null)
            return;

        Stack<Node<T>> st1 = new Stack<>();
        Stack<Node<T>> st2 = new Stack<>();

        st1.push(node);

        while (!st1.isEmpty()) {
            Node<T> temp = st1.pop();
            if (temp.left != null)
                st1.push(temp.left);
            if (temp.right != null)
                st1.push(temp.right);
            st2.push(temp);
        }
        while (!st2.isEmpty())
            System.out.print(st2.pop().data + " -> ");
    }

    public static <T extends Comparable<?>> void postOrder_it2(Node<T> node) {
        if (node == null)
            return;
        Stack<Node<T>> st = new Stack<>();
        Node<T> curr = node;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            else {
                Node<T> temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    System.out.print(temp.data + " -> ");
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        System.out.print(temp.data + " -> ");
                    }
                }
                else
                    curr = temp;
            }
        }
    }

    public static <T extends Comparable<?>> List<List<T>> levelOrder(Node<T> node) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        List<List<T>> wrapList = new LinkedList<>();
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

    static class Pair {
        Node node;
        int num;
        <T extends Comparable<?>> Pair(Node<T> node, int num) {
            this.num = num;
            this.node = node;
        }
    }
    public static <T extends Comparable<?>> List<List<T>> multiOrder(Node<T> node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));
        List<T> pre = new ArrayList<>();
        List<T> in = new ArrayList<>();
        List<T> post = new ArrayList<>();
        List<List<T>> list = new ArrayList<>();

        if (node == null)
            return list;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            if (it.num == 1) {
                pre.add((T) it.node.data);
                it.num++;
                st.push(it);
                if (it.node.left != null)
                    st.push(new Pair(it.node.left, 1));
            }

            else if (it.num == 2){
                in.add((T) it.node.data);
                it.num++;
                st.push(it);
                if (it.node.right != null)
                    st.push(new Pair(it.node.right, 1));
            }

            else
                post.add((T) it.node.data);
        }

        list.add(pre);
        list.add(in);
        list.add(post);

        return list;
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

        System.out.println("\nIterative Pre-Order Traversal:");
        preOrder_it(root);

        System.out.println("\nIterative In-Order Traversal:");
        inOrder_it(root);

        System.out.println("\nIterative Post-Order 1 Traversal:");
        postOrder_it1(root);

        System.out.println("\nIterative Post-Order 2 Traversal:");
        postOrder_it2(root);
    }
}
