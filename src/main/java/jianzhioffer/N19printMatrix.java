package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 范群松.
 * Date：2018/8/20
 * Time: 19:58
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class N19printMatrix {
    public static void main(String[] args) {
        int[][] num = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = new N19printMatrix().printMatrix(num);
        System.out.println(list);
    }



    /*



        1  2  3


        5  6  7
        9 10  11

        13 14 15






     */

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
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
