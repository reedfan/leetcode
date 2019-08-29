package leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

 示例:

 输入:
 words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 输出: ["eat","oath"]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-search-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords212 {
    boolean[][] visted;
    int x, y;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return list;
        }
        x = board.length;
        y = board[0].length;
        for (String word:words){
            if(exist(board,word)){
                list.add(word);
            }
        }
        return list;
    }

    public boolean exist(char[][] board, String word) {


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
