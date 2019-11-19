package leetcode.array;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N042Trap {
    /*对于每一根柱子上最后接的雨水。其结果应该是其左右两边高度的最小值，减去本柱子的高度。
    举个例子，柱子高度为[2,1,5]。最后高度为1的柱子上盛放的雨水的高度应该为min(5,20)-1=1。
    因此对于本题，我们只需要将每根柱子左右两边最大值的较小值减去自己，即可得到解。
     */
    public int trap(int[] height) {

        if(height == null || height.length < 3){
            return 0;
        }
        //left[i]表示第i列左边的最高的列值,包含第i列
        int[] left = new int[height.length];

        left[0] = height[0];

        for (int i = 1; i < height.length ; i++) {
            left[i] = left[i-1] > height[i]?left[i-1] : height[i];
        }
        //right[i]表示第i列右边的最高的列值,包含第i列
        int[] right = new int[height.length];

        right[height.length -1] = height[height.length-1];

        for (int i = height.length-2; i >= 0 ; i--) {
            right[i] = right[i+1] > height[i]?right[i+1] : height[i];
        }
        int sum = 0;
        for (int i = 1; i < height.length-1 ; i++) {
            sum += Math.min(left[i],right[i])-height[i];
        }
        return sum;

    }
}
