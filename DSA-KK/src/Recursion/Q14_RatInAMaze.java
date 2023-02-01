package Recursion;

import utils.Main.*;
import java.util.*;

public class Q14_RatInAMaze {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        System.out.println(findPath(m, n));
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        int[][] vis = new int[n][n];
        if (m[0][0] == 1) solve(0, 0, m, n, res, "", vis);
        return res;
    }

    private static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move, int vis[][]) {
        if (i == n-1 && j == n-1) {
            ans.add(move);
            return;
        }

        // downward
        if (i+1 < n && vis[i+1][j] == 0 && a[i+1][j] == 1) {
            vis[i][j] = 1;
            solve(i+1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }
        // leftward
        if (j-1 >= 0 && vis[i][j-1] == 0 && a[i][j-1] == 1) {
            vis[i][j] = 1;
            solve(i, j-1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }
        // rightward
        if (j+1 < n && vis[i][j+1] == 0 && a[i][j+1] == 1) {
            vis[i][j] = 1;
            solve(i, j+1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }
        // upward
        if (i-1 >= 0 && vis[i-1][j] == 0 && a[i-1][j] == 1) {
            vis[i][j] = 1;
            solve(i-1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
}
