package leetcode.digui;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）  79
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist79 {
    boolean[][] visted;
    int x, y;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        x = board.length;
        y = board[0].length;
        visted = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (process(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, int row, int col, String word, int index) {
        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }

        if (board[row][col] == word.charAt(index)) {
            visted[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = row + d[i][0];
                int newCol = col + d[i][1];
                if (legal(newRow, newCol) && !visted[newRow][newCol] && process(board, newRow, newCol, word, index + 1)) {
                    return true;
                }
            }
            visted[row][col] = false;
        }
        return false;
    }

    private boolean legal(int row, int col) {
        return row >= 0 && row < x && col >= 0 && col < y;
    }
}
