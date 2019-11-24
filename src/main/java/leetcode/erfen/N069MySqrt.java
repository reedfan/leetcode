package leetcode.erfen;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）    69
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N069MySqrt {
    public static void main(String[] args) {
        System.out.println(new N069MySqrt().mySqrt(2147395599));
    }

    /*
    本题的解法类似于数学中的夹逼定理。从两边向中间以二分的方式进行夹击。
    里面还有一些小技巧。为了防止数据越界。比如 a很大。我们要比较a*a和b的大小。因为a*a可能超过Integer.MAX_VALUE。
    所以可以比较a和b/a的大小。

     */
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int start = 1;
        int end = x / 2 + 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            //防止越界
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
