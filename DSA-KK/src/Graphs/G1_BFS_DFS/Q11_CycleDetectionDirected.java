package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q11_CycleDetectionDirected {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int ne : adj.get(node)) {
            if (!vis[ne]) {
                if (dfs(ne, adj, vis, pathVis))
                    return true;
            }
            else if (pathVis[ne])
                return true;
        }

        pathVis[node] = false;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V], pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                if (dfs(i, adj, vis, pathVis))
                    return true;
        }

        return false;
    }
}
