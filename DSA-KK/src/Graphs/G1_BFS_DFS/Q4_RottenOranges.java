package Graphs.G1_BFS_DFS;
import java.util.*;

public class Q4_RottenOranges {
    static class Triplet {
        int row, col, tm;
        Triplet(int _row, int _col, int _tm) {
            this.row = _row;
            this.col = _col;
            this.tm = _tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Triplet> queue = new ArrayDeque<>();
        int countOne = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Triplet(i, j, 0));
                    vis[i][j] = 2;
                }
                else
                    vis[i][j] = 0;

                if (grid[i][j] == 1)
                    countOne++;
            }
        }

        int maxTime = 0, cnt = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Triplet p = queue.poll();
            int r = p.row, c = p.col, t = p.tm;
            maxTime = Math.max(maxTime, t);

            for (int i = 0; i < 4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && grid[nr][nc] == 1 && vis[nr][nc] != 2) {
                    queue.offer(new Triplet(nr, nc, t+1));
                    vis[nr][nc] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != countOne)
            return -1;
        return maxTime;
    }
}
