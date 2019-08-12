package jianzhioffer.digui;

/**
 * created by reedfan on 2019/8/12 0012
 */

/**
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。

 示例:  leetcode 52

 输入: 4
 输出: 2
 */
public class TotalNQueens52 {

    public int totalNQueens(int n) {
        if(n < 4){
            return 0;
        }
        int[] col = new int[n];

        return help(0,n,col);
    }
    private int help(int index, int n, int[] col){
        if(index == n){

        }
        for (int i = 0; i < n; i++) {
            if(){

            }


        }

    }

    private boolean legal(int i, int j){



    }
}
