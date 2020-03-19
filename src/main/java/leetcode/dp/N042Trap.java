package leetcode.dp;

public class N042Trap {

    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = height[i];
            for (int left = i - 1; left >= 0; left--) {
                leftMax = leftMax > height[left] ? leftMax : height[left];
            }
            int rightMax = height[i];
            for (int right = i + 1; right < height.length; right++) {
                rightMax = rightMax > height[right] ? rightMax : height[right];
            }
            sum += Math.min(leftMax, rightMax) - height[i];

        }
        return sum;
    }

    /*
    对于每根柱子，找到其左边的最大值，右边的最大值，然后两者中的较小的减去本根柱子的高度，就是本根柱子上能存放的雨水。
    比如 7  4  5   6
    因为7是最左边的数，因此，本根柱子能存放的雨水为0，
    对于4，其左边的最大值为7，右边的最大值为6.本根柱子能存放的雨水为min(7,6) - 4  = 2
    对于5，其左边的最大值为7，右边的最大值为6.本根柱子能存放的雨水为min(7,6) - 1  = 1
    因为6是最右边的数，因此，本根柱子能存放的雨水为0。
    因此我们可以建两个数组left[]用来存放某个位置左边的最大值、right[]用来存放某个位置左边的最大值
    min(left[i],right[i]) - height[i]就是本位置能存放雨水的值。
     */
    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;
        //left[i]表示第i列左边的最高的列值,包含
        int[] left = new int[height.length];
        left[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            left[i] = left[i - 1] > height[i] ? left[i - 1] : height[i];
        }

        int[] right = new int[height.length];
        right[height.length - 1] = height[right.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] > height[i] ? right[i + 1] : height[i];
        }
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(left[i], right[i]) - height[i];

        }
        return sum;

    }

}
