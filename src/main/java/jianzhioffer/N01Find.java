package jianzhioffer;

/**
 * Author 范群松.
 * Date：2018/8/19
 * Time: 10:54
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class N01Find {
    public boolean Find(int target, int[][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        int posX = 0;
        int posY = col - 1;
        //从右上角往左下角找
        while (posX < row && posY >= 0) {
            if (array[posX][posY] == target) {
                return true;
            }
            if (array[posX][posY] > target) {
                posY--;
            } else {
                posX++;
            }
        }
        return false;
    }
}
