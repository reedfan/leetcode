package leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class N179largestNumber {


    public String largestNumber(int[] nums) {



        /*Collections.sort(nums,new Comparator<Integer>(){
            @Override
            public int compare(int o1, int o2) {
                int x1 = o1;
                int x2 = o2;
                while (x1 / 10 != 0) {
                    x1 /= 10;
                    x2 *= 10;
                }
                while (o2 / 10 != 0) {
                    o2 /= 10;
                    o1 *= 10;
                }
                return (o1 + o2) - (x2 + x1);
            }
        });*/


        return "";



    }


}
