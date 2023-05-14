package Graphs.G1_BFS_DFS;

public class Q3_FloodFill {
    private void dfs(int row, int col, int[][] image, int[][] ans, int newColor, int initialColor, int[] delRow, int[] delCol) {
        ans[row][col] = newColor;

        int n = image.length, m = image[0].length;

        // Check and go to all 4 directions from [row, col]
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && image[nRow][nCol] == initialColor && ans[nRow][nCol] != newColor)
                dfs(nRow, nCol, image, ans, newColor, initialColor, delRow, delCol);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, +1, 0, -1};
        dfs(sr, sc, image, ans, color, initialColor, delRow, delCol);
        return ans;
    }
}
