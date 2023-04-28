package Leetcode;

import java.util.*;

public class SimilarStringGroups {
    public boolean isSimilar(String s, String t) {
        if (s.equals(t))
            return true;
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                diff++;
            if (diff > 2)
                return false;
        }

        return (diff == 0 || diff == 2);
    }

    public void dfs(int node, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;

        for (int it : adj[node]) {
            if (!visited[it])
                dfs(it, visited, adj);
        }
    }


    public int numSimilarGroups(String[] strs) {
        // Init Adjacency List
        int n = strs.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        // Get Adjacencies
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        // DFS to count no. of connected components
        boolean[] visited = new boolean[n];

        // DFS
        int nComp = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                nComp++;
            }
        }

        return nComp;
    }
}
