package jianzhioffer.digui;

/**
 * created by reedfan on 2019/8/12 0012
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。

 示例:  leetcode 52

 输入: 4
 输出: 2
 */
public class TotalNQueens52 {


    public static void main(String[] args) {
        new TotalNQueens52().totalNQueens(4);
    }
    int cnt = 0;

    public int totalNQueens(int n) {
        if(n < 1){
            return 0;
        }
        List<Integer>list = new ArrayList<>();

         help(0,n,list);
         return cnt;
    }
    private void help(int row, int n, List<Integer> list){
        if(row == n){
            cnt++;
            return;

        }
        //每一列都尝试一下
        for (int col = 0; col < n; col++) {
            //当前列是否合法
            if (!list.contains(col)) {
                //左斜与右协是否哈法
                if(!isDiagonalAttack(list,col)){
                   list.add(col);
                   help(row+1,n,list);
                   //回溯
                    list.remove(list.size()-1);
                }
            }

        }

    }

    private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
        int currentRow = currentQueen.size();
        int currentCol = i;
        //判断每一行的皇后的情况
        for (int row = 0; row < currentQueen.size(); row++) {
            //左上角的对角线和右上角的对角线，差要么相等，要么互为相反数，直接写成了绝对值
            if (Math.abs(currentRow - row) == Math.abs(currentCol - currentQueen.get(row))) {
                return true;
            }
        }
        return false;
    }
}
