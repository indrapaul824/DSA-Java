package Binary_Trees;
import java.util.*;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class Q21_ConstructBTPreIn {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }
    
    // With No Duplicates
    public static Node buildTree(int[] inorder, int[] preorder, int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildTree(preorder, 0, preorder.length-1,
                0, inorder.length-1, map);
    }

    public static Node buildTree(int[] preorder, int preStart, int preEnd,
                                 int inStart, int inEnd,
                                 Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preorder[preStart]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsLeft,
                inStart, inRoot-1, map);

        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd,
                inRoot+1, inEnd, map);

        return root;
    }

    // With Duplicates
    public static Node buildTree_dup(int[] inorder, int[] preorder, int n)
    {

        return buildTree(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public static int find(int[] inorder, int data, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == data)
                return i;
        }
        return -1;
    }

    public static Node buildTree(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preorder[preStart]);

        int inRoot = find(inorder, root.data, inStart, inEnd);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsLeft,
                inorder, inStart, inRoot-1);

        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd,
                inorder, inRoot+1, inEnd);

        return root;
    }
}
