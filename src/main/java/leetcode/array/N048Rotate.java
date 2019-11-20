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

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N048Rotate {
    /*
    对于这种旋转类的题目。首先要选准基准点。选好基准点以后会事半功倍。本题我么可以选准左上角和右下角两个基准点。
   第一轮对下列数字进行旋转。定点为[0,0]和[3,3]
   [
   [ 5, 1, 9,11],
   [ 2,      10],
   [13,       7],
   [15,14,12,16]
   ]

   第二轮对下列数字进行旋转。定点为[1,1]和[2,2]。
   [
   [3, 6],
   [14,12]
   ]
   怎么旋转？对于5，11，16，15这几个数字。首先用tmp暂存5.然后将15放到5的位置，16放到15的位置，11放到16的位置。最后将tmp放到11的位置。
   根据这种规律即可完成旋转。


     */
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
