package leetcode.gredy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N053MaxSubArray {

    /*
    当记录到第n个数的时候 ，用一个变量sum记录连续序列的和。那么如果sum<=0的话。
    表明sum+nums[n]将会小于nums[n]。因此。如果我么要找最大的序列和，前面的sum对我们是没有帮助的。
    我们应该将其舍弃。即sum = nums[n]。如果sum > 0的话。sum+nums[n]将会大于nums[n]。
    因此sum = sum+nums[n]。
    用res表示最大子序列和。每次更新完sum的值，看看sum是否比res大。如果比res大，更新res为num的值。
     */


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = res > sum ? res : sum;
        }

        return res;
    }
}
