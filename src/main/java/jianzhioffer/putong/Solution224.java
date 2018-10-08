package jianzhioffer.putong;

import java.util.Arrays;

/**
 * Author 范群松.
 * Date：2018/9/19
 * Time: 16:48
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Solution224 {
    public static void main(String[] args) {
        int[] arr = {2 ,3,6,1,4,3,5,8};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reOrderArray(int [] array) {
        int i = 0;
        int j = -1;
        int firstodd = 0;
        while (i<array.length){
            //找出偶数的位置
            while (i<array.length&&!isEven(array[i])){
                i++;
            }
            //找出奇数出现的位置
            j = i+1;
            while (j<array.length&&isEven(array[j])){
                j++;
            }
            if(j<array.length){
                //调换位置
                firstodd = array[j];

                for (int k = j-1 ; k >=i ; k--) {
                    array[k+1] = array[k];
                }
                array[i++] = firstodd;

            }else {
                break;
            }

        }
    }


    private static Boolean isEven(int num){
        if(num%2 == 0){
            return true;
        }
        return false;
    }
}
