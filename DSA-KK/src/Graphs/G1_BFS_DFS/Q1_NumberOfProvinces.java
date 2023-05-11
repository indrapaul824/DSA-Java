package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q1_NumberOfProvinces {

    private static void dfs(int node, boolean[] vis, ArrayList<Integer>[] adjList) {
        vis[node] = true;

        for (int n : adjList[node]) {
            if (!vis[n])
                dfs(n, vis, adjList);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, vis, adjList);
            }
        }

        return cnt;
    }
}
