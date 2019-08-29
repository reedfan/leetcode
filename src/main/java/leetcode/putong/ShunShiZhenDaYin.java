package leetcode.putong;

import java.util.ArrayList;

/**
 * created by reedfan on 2019/5/8 0008
 */
public class ShunShiZhenDaYin {

    public static void main(String[] args) {

        int [][] matrix = {{1}};

        ArrayList<Integer> list= printMatrix(matrix);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }


    }


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new  ArrayList<Integer>();
        int startX = 0;
        int startY = 0;
        int endX = matrix.length-1;
        int endY =  matrix[0].length-1;
        while(startX < endX && startY<endY){
            for(int i = startY;i<endY;i++){
                list.add(matrix[startX][i]);
            }

            for(int i = startX;i<endX;i++){
                list.add(matrix[i][endY]);
            }

            for(int i = endY;i>startY;i--){
                list.add(matrix[endX][i]);
            }

            for(int i = endX;i>startX;i--){
                list.add(matrix[i][startX]);
            }

            startX++;
            endX--;
            startY++;
            endY--;

        }

        if(startX == endX){
            for(int i = startY;i<=endY;i++){
                list.add(matrix[startX][i]);
            }

        }

        if(startY == endY){
            for(int i=startX;i<=endX;i++ ){
                list.add(matrix[i][startY]);
            }

        }




        return list;

    }
}
