package Graphs.G1_BFS_DFS;

import java.util.Arrays;

public class Q7_SurroundedRegions {
    private static void dfs(int r, int c, char[][] board, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[r][c] = true;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = r + delRow[i], nc = c + delCol[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && board[nr][nc] == 'O')
                dfs(nr, nc, board, vis, delRow, delCol);
        }
    }
    public static void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] delRow = {-1, 0, 1, 0}, delCol = {0, 1, 0, -1};

        // Top and Bottom Rows
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && board[0][j] == 'O')
                dfs(0, j, board, vis, delRow, delCol);

            if (!vis[n-1][j] && board[n-1][j] == 'O')
                dfs(n-1, j, board, vis, delRow, delCol);
        }

        // Left and Right Columns
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O')
                dfs(i, 0, board, vis, delRow, delCol);

            if (!vis[i][m-1] && board[i][m-1] == 'O')
                dfs(i, m-1, board, vis, delRow, delCol);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};

        for (char[] row : board)
            System.out.println(Arrays.toString(row));
        System.out.println();

        solve(board);

        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }
}
