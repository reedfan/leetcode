package leetcode.putong;

import java.util.ArrayList;

/**
 * Author 范群松.
 * Date：2018/8/17
 * Time: 21:21
 *
 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 如果有多对数字的和等于S，输出两个数的乘积最小的。
 输出描述:

 对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution22 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int end = array.length-1;
        while (start < end){
            if(array[start] + array[end] == sum){
                list.add(array[start]);
                list.add(array[end]);
                break;
            }else {
                if(array[start] + array[end] < sum){
                    start ++;
                }else {
                    end --;
                }
            }
        }
        return list;
    }
}
