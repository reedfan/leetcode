package leetcode.array;

import java.util.*;

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

    public static void main(String[] args) {

        int[] nums = {0,3,30,34,5,9};
        System.out.println(largestNumber(nums));

    }


    public static String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }


        //自带的比较器不能使用 int 类型，所以我们把它转为 Integer 类型
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }


        Arrays.sort(newNums, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                if(o2 == 0){
                    return -1;
                }
                int x1 = o1;
                int x2 = o2;
                int y1 = o1;
                int y2 = o2;
                while (x1  != 0) {
                    x1 /= 10;
                    x2 *= 10;
                }
                while (y2  != 0) {
                    y2 /= 10;
                    y1 *= 10;
                }
                return   (o1 + x2) - (y1 + o2)  ;
            }
        });

        if(newNums[0] == 0){
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for (Integer num : newNums) {
            sb.append(num);
        }
        return sb.toString();


    }


}
