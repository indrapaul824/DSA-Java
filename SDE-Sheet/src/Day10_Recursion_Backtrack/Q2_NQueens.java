package Day10_Recursion_Backtrack;
import java.util.*;

public class Q2_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int[] lD = new int[2*n-1], uD = new int[2*n-1], lH = new int[n];
        solve(0, n, board, res, lD, uD, lH);
        return res;
    }

    private void solve(int col, int n, char[][] board, List<List<String>> res, int[] lD, int[] uD, int[] lH) {
        if (col == n) {
            res.add(toStringList(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (lH[row] == 0 && lD[row+col] == 0 && uD[n-1+col-row] == 0) {
                lH[row] = 1;
                lD[row+col] = 1;
                uD[n-1+col-row] = 1;
                board[row][col] = 'Q';
                solve(col+1, n, board, res, lD, uD, lH);

                board[row][col] = '.';
                lH[row] = 0;
                lD[row+col] = 0;
                uD[n-1+col-row] = 0;
            }
        }
    }

    private List<String> toStringList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] ch : board)
            list.add(new String(ch));
        return list;
    }


}
