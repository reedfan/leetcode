package leetcode.array;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）  73
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N073SetZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstColHasZero = false;
        for (int i = 0; i < row ; i++) {
            //第一列是否有0值
            if(matrix[i][0] == 0){
                firstColHasZero = true;
            }
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }

        }


        //行置零
        for (int i = 1; i < row; i++) {
            if(matrix[i][0] == 0){
                for (int j = 1; j <col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //列置零
        for (int i = 1; i < col; i++) {
            if(matrix[0][i] == 0){
                for (int j = 1; j<row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //第一行
        if(matrix[0][0] == 0){
            for (int j = 1; j <col; j++) {
                matrix[0][j] = 0;
            }
            
        }
        //第一列
        if(firstColHasZero){
            for (int i = 0; i < row ; i++) {
                matrix[i][0] = 0;
                
            }
        }

    }
}
