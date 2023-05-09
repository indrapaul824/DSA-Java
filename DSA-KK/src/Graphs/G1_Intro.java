package Graphs;
import utils.Main.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G1_Intro {
    public static void main(String[] args) {
        FastReader in = new FastReader();

        // Declare the No. of Nodes and Edges
        System.out.println("Enter the No. of nodes and edges:");
        int n = in.nextInt(), m = in.nextInt();

        // Assuming we are given input as unique edges / pair of nodes of the 1-indexed graph
        // Like this:
        // 1 2
        // 1 3
        // 2 4
        // 3 4
        // 2 5
        // 4 5

        // Adjacency Matrix Representation
        int[][] adj = new int[n+1][n+1];

        System.out.println("Enter the edges / node pairs:");
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        System.out.println("Adjacency Matrix Representation:");
        for (int[] row : adj)
            System.out.println(Arrays.toString(row));


        // Declare the No. of Nodes and Edges
        System.out.println("Enter the No. of nodes and edges:");
        n = in.nextInt();
        m = in.nextInt();

        // Adjacency List Representation
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges / node pairs:");
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        System.out.println("Adjacency List Representation:");
        for (List<Integer> row : adjList)
            System.out.println(row);
    }
}
