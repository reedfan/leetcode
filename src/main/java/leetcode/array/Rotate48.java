package leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10 ,11]
 * ]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (rowStart < rowEnd) {
            help(matrix,rowStart,colStart,rowEnd,colEnd);
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
    }

    private void help(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd) {
        int time = rowEnd - rowStart;
        for (int i = 0; i < time; i++) {
            int tmp = matrix[rowStart][colStart + i];
            matrix[rowStart][colStart + i] = matrix[rowEnd - i][colStart];
            matrix[rowEnd - i][colStart] = matrix[rowEnd][colEnd - i];
            matrix[rowEnd][colEnd - i] = matrix[rowStart + i][colEnd];
            matrix[rowStart + i][colEnd] = tmp;

        }
    }
}
