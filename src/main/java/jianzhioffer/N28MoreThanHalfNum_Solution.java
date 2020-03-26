package jianzhioffer;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author 范群松.
 * Date：2018/8/27
 * Time: 20:21
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */





public class N28MoreThanHalfNum_Solution {



    public int MoreThanHalfNum_Solution(int[] nums) {
        int a = nums[0];
        int cnta = 0;
        for (int num : nums) {
            if (num == a) {
                cnta++;
                continue;
            }
            if (cnta == 0) {
                a = num;
                cnta = 1;
                continue;
            }
            cnta--;
        }

        cnta = 0;

        for (int num : nums) {
            if (num == a) {
                cnta++;
            }
        }
        if (cnta <= nums.length / 2) {
            return 0;
        }
        return a;
    }
}
