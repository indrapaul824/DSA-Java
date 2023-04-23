package Practice.Algorithms.SDOT;
import java.util.*;

public class HamiltonianCycle {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 1, 1},
                { 1, 0, 1, 1},
                { 1, 1, 0, 1},
                { 1, 1, 1, 0},
        };
        int[] path = new int[graph.length];
        path[0] = 0;
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        int ans = hamiltonianCycleCount(graph, 0, 0, path, visited);
        System.out.println(ans);

        // Create a weighted graph and find the Hamiltonian path with the minimum weight
        int[][] weightedGraph = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };
        int[] path2 = new int[weightedGraph.length];
        path2[0] = 0;
        boolean[] visited2 = new boolean[weightedGraph.length];
        visited2[0] = true;
        int[] minPath = new int[weightedGraph.length];
        minPath[0] = 0;
        int minWeight = Integer.MAX_VALUE;
        int weight = 0;
        hamiltonianCycleMinWeight(weightedGraph, 0, 0, path2, visited2, weight, minWeight, minPath);
        System.out.println(minWeight);
        System.out.println(Arrays.toString(minPath));
    }

    private static int hamiltonianCycleCount(int[][] graph, int i, int j, int[] path, boolean[] visited) {
        if (j == graph.length - 1) {
            if (graph[i][0] == 1) {
                path[j] = 0;
                for (int value : path) {
                    System.out.print((value+1) + " ");
                }
                System.out.println();
                return 1;
            }
            return 0;
        }
        int count = 0;
        for (int k = 0; k < graph.length; k++) {
            if (graph[i][k] == 1 && !visited[k]) {
                visited[k] = true;
                path[j] = k;
                count += hamiltonianCycleCount(graph, k, j + 1, path, visited);
                visited[k] = false;
            }
        }
        return count;
    }

    // Find the Hamiltonian path with the minimum weight in a weighted graph
    private static void hamiltonianCycleMinWeight(int[][] graph, int i, int j, int[] path, boolean[] visited,
                                                  int weight, int minWeight, int[] minPath) {
        if (j == graph.length - 1) {
            if (graph[i][0] != 0) {
                path[j] = 0;
                weight += graph[i][0];
                if (weight < minWeight) {
                    minWeight = weight;
                    System.arraycopy(path, 0, minPath, 0, path.length);
                }
            }
            return;
        }
        for (int k = 0; k < graph.length; k++) {
            if (graph[i][k] != 0 && !visited[k]) {
                visited[k] = true;
                path[j] = k;
                weight += graph[i][k];
                hamiltonianCycleMinWeight(graph, k, j + 1, path, visited, weight, minWeight, minPath);
                visited[k] = false;
                weight -= graph[i][k];
            }
        }
    }
}
