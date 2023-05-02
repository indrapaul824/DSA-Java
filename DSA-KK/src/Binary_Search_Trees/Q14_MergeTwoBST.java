package Binary_Search_Trees;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

public class Q14_MergeTwoBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }


    // Approach 1
    ArrayList<Integer> arr = new ArrayList<>();
    public void inorder(Node root) {
        if(root!=null){
            inorder(root.left);
            arr.add(root.data);
            inorder(root.right);
        }
    }

    public List<Integer> merge(Node root1, Node root2)
    {
        inorder(root1);
        inorder(root2);
        Collections.sort(arr);
        return arr;
    }
}
