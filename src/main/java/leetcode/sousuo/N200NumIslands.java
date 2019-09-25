package leetcode.sousuo;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N200NumIslands {
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
