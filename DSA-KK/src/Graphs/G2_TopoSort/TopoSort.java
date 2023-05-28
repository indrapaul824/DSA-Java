package Graphs.G2_TopoSort;
import java.util.*;

public class TopoSort {

    // Using DFS and Stack
    private static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;

        for (int ne : adj.get(node)) {
            if (vis[ne] == 0)
                dfs(ne, vis, st, adj);
        }

        st.push(node);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V], linearOrd = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, vis, st, adj);
        }

        int i = 0;
        while (!st.isEmpty()) {
            linearOrd[i++] = st.pop();
        }

        return linearOrd;
    }


    // Using BFS - Kahn's Algorithm
    static int[] topoSort_bfs(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V], topo = new int[V];
        Queue<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            for (int ne : adj.get(i))
                inDegree[ne]++;
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                Q.offer(i);
        }

        int i = 0;
        while (!Q.isEmpty()) {
            int node = Q.poll();
            topo[i++] = node;

            for (int ne : adj.get(node)) {
                inDegree[ne]--;

                if (inDegree[ne] == 0)
                    Q.offer(ne);
            }
        }

        return topo;
    }
}
