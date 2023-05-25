package Graphs.G1_BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;

public class Q9_NumberOfDistinctIslands {

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};
    private boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private void dfs(int row, int col, boolean[][] vis, int[][] grid, ArrayList<String> list, int oRow, int oCol) {
        vis[row][col] = true;
        list.add(toString(row - oRow, col - oCol));

        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i], nCol = col + delCol[i];

            if (isValid(nRow, nCol, n, m) && !vis[nRow][nCol] && grid[nRow][nCol] == 1)
                dfs(nRow, nCol, vis, grid, list, oRow, oCol);
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, list, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }
}
