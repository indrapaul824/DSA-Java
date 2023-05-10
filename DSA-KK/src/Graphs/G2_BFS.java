package Graphs;
import java.util.*;

public class G2_BFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Data Structures
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();

        // Initial Configuration
        vis[0] = true;
        q.offer(0);

        // Traverse
        while (!q.isEmpty()) {
            int curr = q.poll();
            bfs.add(curr);

            for (int i : adj.get(curr)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }

        return bfs;
    }
}
