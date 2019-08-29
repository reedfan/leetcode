package leetcode.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueue51 {

    public static void main(String[] args) {
        new Nqueue51().solveNQueens(4);
    }
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n < 1){
            return res;
        }
        List<Integer> list = new ArrayList<>();

        help(0,n,list);
        return res;
    }
    private void help(int row, int n, List<Integer> list){
        if(row == n){
            List<String> strList = new ArrayList<>();
            for(Integer num:list){
                char[] t = new char[n];
                Arrays.fill(t,'.');
                t[num] = 'Q';
                strList.add(new String(t));
            }
            res.add(strList);
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
        // TODO Auto-generated method stub
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
