package Binary_Trees;
import java.util.*;

public class Q22_ConstructBTPostIn {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    Node buildTree(int[] in, int[] post, int n) {
        if (in == null || post == null || in.length != post.length)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++)
            map.put(in[i], i);

        return buildTreeInPost(in, 0, in.length-1, post, 0, post.length-1, map);
    }

    private Node buildTreeInPost(int[] in, int is, int ie, int[] post, int ps, int pe, Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;

        Node root = new Node(post[pe]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot - is;

        root.left = buildTreeInPost(in, is, inRoot-1, post, ps, ps+numsLeft-1, map);

        root.right = buildTreeInPost(in, inRoot+1, ie, post, ps+numsLeft, pe-1, map);

        return root;
    }
}
