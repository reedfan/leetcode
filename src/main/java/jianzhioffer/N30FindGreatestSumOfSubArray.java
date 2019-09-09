package jianzhioffer;

/**
 * Author 范群松.
 * Date：2018/8/18
 * Time: 21:59
 * 连续子数组最大和
 */

public class N30FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int total = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (total > 0) {   //如果当前数据前面的total大于0，则total对数据有贡献
                total += array[i];
            } else {
                total = array[i];  //否则将当前值赋给total
            }
            if (max < total) {
                max = total;    //total和max进行比较
            }
        }
        return max;

    }
}
