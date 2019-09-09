package jianzhioffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class N13ReOrderArray {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        new N13ReOrderArray().reOrderArray(array);
    }

    public void reOrderArray(int[] array) {
        if(array.length == 0 || array.length ==1){
            return;
        }
        int cntOdd = 0;
        int tmpPos = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] % 2 == 1){
                tmpPos = i;
                while (tmpPos > cntOdd){
                    int tmp = array[tmpPos];
                    array[tmpPos] = array[tmpPos-1];
                    array[tmpPos-1] = tmp;
                    tmpPos--;
                }
                cntOdd++;
            }
        }
    }
    public void reOrderArray1(int[] array) {
        if(array.length == 0 || array.length ==1){
            return;
        }

        int len = array.length;
        int[] tmp = new int[len];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (!isEven(array[i])) {
                tmp[pos++] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (isEven(array[i])) {
                tmp[pos++] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            array[i] = tmp[i];
        }
    }

    private boolean isEven(int target) {
        if (target % 2 == 0) {
            return true;
        }
        return false;
    }
}
