package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q6_01Matrix {
    static class Triplet {
        int row, col, d;

        public Triplet(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Declare and Initialize
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        int[] delRow = {-1, 0, 1, 0}, delCol = {0, 1, 0, -1};

        Queue<Triplet> Q = new ArrayDeque<>();

        // Push all the source nodes to Queue and mark visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Q.offer(new Triplet(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            Triplet t = Q.poll();
            int r = t.row, c = t.col, d = t.d;

            dist[r][c] = d;

            // Traverse the neighbours
            for (int i = 0; i < 4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && !vis[nr][nc]) {
                    Q.offer(new Triplet(nr, nc, d+1));
                    vis[nr][nc] = true;
                }
            }
        }

        return dist;
    }
}
