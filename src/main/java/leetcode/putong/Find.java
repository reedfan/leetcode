package leetcode.putong;

/**
 * created by reedfan on 2019/4/25 0025
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public boolean find(int target, int [][] array) {
        int hang = array.length;
        int lie  = array[0].length;

        int i = 0;
        int j = lie-1;

        while (i<hang && j>=0){
            if(array[i][j] == target){
                return true;
            }else {
                if(array[i][j] < target){
                    i++;
                }else {
                    j--;
                }
            }

        }
        return false;

    }
}
