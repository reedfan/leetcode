package leetcode.array;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 10:54
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Solution27 {

    public boolean Find(int target, int [][] array) {
        int hang = array.length;
        int lie = array[0].length;
        int i = 0;
        int j = hang-1;
        //从右上角往左下角找
        while (i<lie && j >= 0){
            if(array[i][j] > target){
                j--;
            }else {
                if(array[i][j] < target){
                    i++;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
