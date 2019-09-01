package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SpiralOrder54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        new SpiralOrder54().spiralOrder(matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int startx = 0;
        int starty = 0;
        int endx = matrix.length-1;
        int endy = matrix[0].length-1;
        while (startx < endx && starty < endy) {
            for (int i = starty; i < endy ; i++) {
                list.add(matrix[startx][i]);
            }
            for (int i = startx; i < endx ; i++) {
                list.add(matrix[i][endy]);

            }
            for (int i = endy; i > starty; i--) {
                list.add(matrix[endx][i]);

            }
            for (int i = endx ; i > startx; i--) {
                list.add(matrix[i][starty]);
            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        //只有一行时
        if(starty == endy){
            while (startx <= endx) {
                list.add(matrix[startx++][starty]);
            }
        }else {
            //只有一列时
            if(startx == endx){
                while (starty <= endy) {
                    list.add(matrix[startx][starty++]);
                }

            }

        }
        return list;
    }
}
