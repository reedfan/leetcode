package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 *
 *     1 是丑数。
 *     n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N264nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(new N264nthUglyNumber().nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {

        int[] nums = new int[n];

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int tmp = 1;
        nums[0] = 1;

        int value2 = 0;
        int value3 = 0;
        int value5 = 0;
        int cnt = 1;
        while (cnt < n) {
            value2 = nums[index2] * 2;
            value3 = nums[index3]* 3;
            value5 = nums[index5] * 5;
            tmp = Math.min(value2, Math.min(value3, value5));
            nums[cnt++] = tmp;
            if (tmp == value2) {
                index2++;
            }
            if (tmp == value3) {
                index3++;
            }
            if (tmp == value5) {
                index5++;
            }
        }
        return nums[n-1];

    }
}
