package leetcode.shuangzhizhen;

/**
 * created by reedfan on 2019/12/19 0019
 */
public class N011maxArea {
    /*
    本题可以采用从两边向中间夹击的形式。每个过程能盛的水的容量为左右两边教矮的高度乘以宽度。
    并且，如果左边的高度较小。下一次将左边向右移一位。如果右边的高度比较小。下一次将右边左移一位。直到左右两边相遇。
    证明如下：
    假设左边高度记为height[left]，右边高度记为height[right]，宽度记为width。此时可盛水min(height[left],height[right])*width
    无论从右向左移动一位，还是从左向右移动一位。宽度都是一样的，为width-1.
    上面说的移动方法用一句话概括就是哪边矮移动哪边。
    试想如果哪边高就移动哪边，会怎么样？
    假设height[left] > height[right],则原来盛水 height[right]*width。则
    min(height[++left],height[right])*（width-1）<= height[right]*(width-1) < height[right]*width.
    也就是移动以后肯定会比移动之前的值小。显然是不行的。
    按照我们的思路哪边矮移动哪边，会怎么样？
    假设height[left] > height[right],则原来盛水 height[right]*width。
    移动以后可盛水min(height[left],height[--right])*（width-1）。
    如果height[right-1]的值比height[right]大的话，虽然宽度变小了。但是min(height[left],height[right-1])一定大于height[right]，
    那么min(height[left],height[right-1])*（width-1）是有可能大于height[right]*width的。



     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int width = right - left;
            if (height[left] < height[right]) {
                res = res > height[left] * width ? res : height[left] * width;
                left++;
            } else {
                res = res > height[right] * width ? res : height[right] * width;
                right--;
            }
        }
        return res;

    }
}
