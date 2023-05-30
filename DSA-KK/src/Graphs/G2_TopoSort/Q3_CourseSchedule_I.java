package Graphs.G2_TopoSort;
import java.util.*;

public class Q3_CourseSchedule_I {
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
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] p : pre) {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] vis = new boolean[n], pathVis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i])
                if (dfs(i, adj, vis, pathVis))
                    return false;
        }

        return true;
    }
}
