package Graphs.G2_TopoSort;
import java.util.*;

public class Q1_FindEventualSafeStates {
    // Using Cycle Detection with DFS
    private void dfs(int node, boolean[] vis, boolean[] pathVis, int[][] graph) {
        vis[node] = true;
        pathVis[node] = true;

        for (int ne : graph[node]) {
            if (!vis[ne])
                dfs(ne, vis, pathVis, graph);
            if (vis[ne] && pathVis[ne])
                return;
        }

        pathVis[node] = false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;

        boolean[] vis = new boolean[m], pathVis = new boolean[m];

        for (int i = 0; i < m; i++) {
            if (!vis[i])
                dfs(i, vis, pathVis, graph);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++)
            if (!pathVis[i])
                list.add(i);

        return list;
    }

    // Using BFS (Topo Sort)

}
