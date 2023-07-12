package Recursion;

public class Q18_WordSearch {
    private final int[] rows = {0, -1, 0, 1}, cols = {-1, 0, 1, 0};
    private boolean dfs(int ind, int i, int j, char[][] board, String word) {
        if (ind == word.length())  return true;

        int n = board.length, m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(ind))
            return false;

        char ch = board[i][j];
        board[i][j] = '#';
        boolean res = false;
        for (int p = 0; p < 4; p++) {
            int r = i + rows[p], c = j + cols[p];
            res = res || dfs(ind+1, r, c, board, word);
        }
        board[i][j] = ch;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length, l = word.length();

        if (n*m < l)
            return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(0, i, j, board, word))
                    return true;
            }
        }

        return false;
    }
}
