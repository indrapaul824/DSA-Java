package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q5_CycleDetectionUndirected {
    // BFS
    static class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(src, -1));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int adjNode : adj.get(p.node)) {
                if (!vis[adjNode]) {
                    queue.offer(new Pair(adjNode, p.node));
                    vis[adjNode] = true;
                }
                else if (adjNode != p.parent)
                    return true;
            }
        }

        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, adj, vis))
                    return true;
            }
        }

        return false;
    }

    // DFS

    boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        for (int adjNode : adj.get(src)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, src, adj, vis))
                    return true;
            }

            else if (adjNode != parent)
                return true;
        }

        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle_dfs(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj, vis))
                    return true;
            }
        }

        return false;
    }
}
