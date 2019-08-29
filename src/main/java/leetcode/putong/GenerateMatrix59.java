package leetcode.putong;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）  59
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateMatrix59 {
    public static void main(String[] args) {
        new GenerateMatrix59().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0){
            return matrix;
        }
        int num = 1;
        int startX = 0;
        int startY = 0;
        int endX = n-1;
        int endY = n-1;
        int tar = n*n;
        while (num <= tar){
            for (int i = startY; i <= endY ; i++) {
                matrix[startX][i] = num++;

            }
            startX++;
            for (int i = startX; i <= endX ; i++) {
                matrix[i][endY] = num++;
            }
            endY--;

            for (int i = endY; i >= startY ; i--) {
                matrix[endX][i] = num++;

            }
            endX--;
            for (int i = endX; i >= startX ; i--) {
                matrix[i][startY] = num++;

            }
            startY++;
        }
        return matrix;

    }
}
