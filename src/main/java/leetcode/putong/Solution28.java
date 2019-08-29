package leetcode.putong;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/20
 * Time: 19:58
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class Solution28 {
    public static void main(String[] args) {
        int[][] num = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = printMatrix(num);
        System.out.println(list);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer>res = new ArrayList<Integer>();

        //控制x
        int i = 0;
        //控制y
        int j = 0;
        int startX = 0;
        int startY = 0;
        int endX = matrix[0].length-1;
        int endY = matrix.length-1;
        while (startX<=endX&&startY<=endY){
            if(startX==endX){
                for (;i<=endY;i++) {
                    res.add(matrix[i][j]);

                }
            }
            if(startY==endY){
                for (;j<=endX;j++){
                    res.add(matrix[i][j]);
                }
            }



        }
        return res;




    }



    /*public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        //起点
        int i = 0;
        int j = 0;
        int startX = 0;
        int endX = m-1;
        int startY = 0;
        int endY = n-1;
        while (startX <= endX && startY <= endY ){
            if(startX == endX){
                for (;i<=endY;i++){
                    res.add(matrix[i][j]);
                    return res;
                }
            }
            if(startY == endY){
                for (;j<=endX;j++){
                    res.add(matrix[i][j]);
                    return res;
                }
            }
            //从左到右
            for (;j<endX;j++){
                res.add(matrix[i][j]);
            }
            //从上到下
            for (;i<endY;i++){
                res.add(matrix[i][j]);
            }
            //从右到左
            for (;j>startX;j--){
                res.add(matrix[i][j]);
            }
            //从下到上
            for(;i>startY;i--){
                res.add(matrix[i][j]);
            }
            //起点加1
            i++;
            j++;
            startX++;
            endX--;
            startY++;
            endY--;


        }
        return res;
    }*/
}
