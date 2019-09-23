package leetcode.array;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode） 221
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N221maximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'0'}, {'1'}};
        new N221maximalSquare().maximalSquare(matrix);
    }

    /**
    dp[i][j]表示以i,j作为右下角的正方形的大小，那么它与三个值有关，dp[i-1][j].dp[i][j-1].dp[i-1][j-1]
     */

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0] - '0';
        int max = dp[0][0];
        //初始化第一行
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = max > dp[0][i] ? max : dp[0][i];
            }
        }
        //初始化第一列
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = max > dp[i][0] ? max : dp[i][0];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int min = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                    dp[i][j] = (min < dp[i - 1][j - 1] ? min : dp[i - 1][j - 1]) + 1;
                    max = max > dp[i][j] ? max : dp[i][j];
                }

            }
        }
        return max * max;

    }

}
