package jianzhioffer.sousuo;

/**
 * created by reedfan on 2019/7/25 0025
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    search(grid, i, j, row, col);
                }
            }
        }
        return num;
    }
    private void search(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        search(grid, x - 1, y, row, col);
        search(grid, x + 1, y, row, col);
        search(grid, x, y - 1, row, col);
        search(grid, x, y + 1, row, col);
    }
}
