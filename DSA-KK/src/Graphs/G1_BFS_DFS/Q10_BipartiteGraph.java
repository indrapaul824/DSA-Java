package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q10_BipartiteGraph {

    // Using BFS
    private boolean check(int start, int[] color, int[][] graph) {
        Queue<Integer> Q = new ArrayDeque<>();

        Q.offer(start);
        color[start] = 0;

        while (!Q.isEmpty()) {
            int node = Q.poll();

            for (int ne : graph[node]) {
                if (color[ne] == -1) {
                    color[ne] = 1 - color[node];
                    Q.offer(ne);
                }
                else if (color[ne] == color[node])
                    return false;
            }
        }

        return true;
    }
    public boolean isBipartite_bfs(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!check(i, color, graph))
                    return false;
            }
        }
        return true;
    }

    // Using DFS
    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int ne : graph[node]) {
            if (color[ne] == -1) {
                if (!dfs(ne, 1 - col, color, graph))
                    return false;
            }
            else if (color[ne] == col)
                return false;
        }

        return true;
    }
    public boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph))
                    return false;
            }
        }
        return true;
    }
}
