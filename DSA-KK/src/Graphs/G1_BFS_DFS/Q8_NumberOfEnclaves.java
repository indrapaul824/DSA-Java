package Graphs.G1_BFS_DFS;

public class Q8_NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] delRow = {-1, 0, 1, 0}, delCol = {0, 1, 0, -1};

        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && grid[0][j] == 1)
                dfs(0, j, grid, vis, delRow, delCol);

            if (!vis[n-1][j] && grid[n-1][j] == 1)
                dfs(n-1, j, grid, vis, delRow, delCol);
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 1)
                dfs(i, 0, grid, vis, delRow, delCol);

            if (!vis[i][m-1] && grid[i][m-1] == 1)
                dfs(i, m-1, grid, vis, delRow, delCol);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[r][c] = true;

        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = r + delRow[i], nc = c + delCol[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1)
                dfs(nr, nc, grid, vis, delRow, delCol);
        }
    }
}
