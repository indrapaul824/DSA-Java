package Graphs.G2_TopoSort;
import java.util.*;

public class Q2_DetectCycleDirected_BFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        Queue<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            for (int ne : adj.get(i))
                inDegree[ne]++;
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                Q.offer(i);
        }

        int i = 0, cnt = 0;
        while (!Q.isEmpty()) {
            int node = Q.poll();
            cnt++;

            for (int ne : adj.get(node)) {
                inDegree[ne]--;

                if (inDegree[ne] == 0)
                    Q.offer(ne);
            }
        }

        return cnt == V;
    }
}
