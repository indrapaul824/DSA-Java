package Recursion;

import utils.Main.*;
import java.util.*;

public class Q13_NQueens {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        System.out.println(solveNQueens(n));
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
//        solve(0, board, res, n);
        int[] lR = new int[n], uD = new int[2*n - 1], lD = new int[2*n - 1];
        solve(0, board, res, lR, uD, lD, n);
        return res;
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int[] lR, int[] uD, int[] lD, int n) {
        if (col == n) {
            res.add(toStringList(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (lR[row]==0 && lD[row+col]==0 && uD[n-1 + col - row]==0) {
                board[row][col] = 'Q';
                lR[row] = 1;
                lD[row+col] = 1;
                uD[n-1 + col - row] = 1;
                solve(col+1, board, res, lR, uD, lD, n);
                board[row][col] = '.';
                lR[row] = 0;
                lD[row+col] = 0;
                uD[n-1 + col - row] = 0;
            }
        }
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int n) {
        if (col == n) {
            res.add(toStringList(board));
            return;
        }
        for (int row=0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col+1, board, res, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int dupcol = col;
        int duprow = row;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        col = dupcol;
        row = duprow;

        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        col = dupcol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private static List<String> toStringList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            list.add(new String(chars));
        }
        return list;
    }
}
