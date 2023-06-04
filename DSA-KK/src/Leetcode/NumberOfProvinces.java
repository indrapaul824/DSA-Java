package Leetcode;
import java.util.*;

public class NumberOfProvinces {
    private void dfs(int node, boolean[] vis, ArrayList<Integer>[] adjList) {
        vis[node] = true;

        for (int n : adjList[node]) {
            if (!vis[n])
                dfs(n, vis, adjList);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
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
        System.gc();
        return cnt;
    }
}
