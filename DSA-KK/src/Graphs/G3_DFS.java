package Graphs;
import java.util.*;

public class G3_DFS {
    void dfs(int node, boolean[] vis, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        res.add(node);

        // Traverse all its neighbours
        for (int i : adj.get(node)) {
            if (!vis[i])
                dfs(i, vis, res, adj);
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, res, adj);
        return res;
    }
}
