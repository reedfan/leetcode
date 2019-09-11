package leetcode.dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N152maxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new N152maxProduct().maxProduct(nums));
    }

    /**
     *
     * 遍历数组时计算当前最大值，不断更新
     令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     当负数出现时则imax与imin进行交换再进行下一步计算
     时间复杂度：O(n)O(n)O(n)

     作者：guanpengchn
     链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int maxValue = nums[0];
        int minValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = maxValue;
                maxValue = minValue;
                minValue = tmp;
            }
            maxValue = maxValue * nums[i] > nums[i] ? maxValue * nums[i] : nums[i];
            minValue = minValue * nums[i] < nums[i] ? minValue * nums[i] : nums[i];
            max = max > maxValue ? max : maxValue;

        }
        return max;

    }
}
