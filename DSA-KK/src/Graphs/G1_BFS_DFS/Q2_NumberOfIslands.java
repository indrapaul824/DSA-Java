package Graphs.G1_BFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q2_NumberOfIslands {
    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        vis[row][col] = true;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, col));
        int n = grid.length, m = grid[0].length;

        while (!queue.isEmpty()) {
            int r = queue.peek().row, c = queue.peek().col;
            queue.remove();

            // Traverse in the neighbours if valid and == 1
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = r + i, nc = c + j;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && grid[nr][nc] == '1' && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        queue.add(new Pair(nr, nc));
                    }
                }
            }
        }
    }

    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1') {
            grid[i][j]='0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(i, j, vis, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
