package Graphs.G2_TopoSort;
import java.util.*;

public class Q4_CourseSchedule_II {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] p : pre)
            adj.get(p[1]).add(p[0]);

        int[] inDegree = new int[n], topo = new int[n];

        Queue<Integer> Q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int ne : adj.get(i))
                inDegree[ne]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                Q.offer(i);
        }

        int i = 0, cnt = 0;
        while (!Q.isEmpty()) {
            int node = Q.poll();
            topo[i++] = node;
            cnt++;

            for (int ne : adj.get(node)) {
                inDegree[ne]--;

                if (inDegree[ne] == 0)
                    Q.offer(ne);
            }
        }

        if (cnt == n)
            return topo;

        return new int[]{};
    }
}
