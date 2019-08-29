package leetcode.shuangzhizhen;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        new ThreeSumClosest16().threeSumClosest(nums, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        assert nums.length > 2;
        Arrays.sort(nums);
        int left;
        int right;
        int sum3;  //数组中的三个数的和
        int res = 0;  //记录返回结果
        int tmp = Integer.MAX_VALUE; //记录sum3和target的差的绝对值
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum3 = nums[left] + nums[right] + nums[i];
                //如果已经找到等于target的三个数，直接返回即可。
                if(sum3 == target){
                    return target;
                }
                if (Math.abs(sum3 - target) < tmp) {
                    tmp = Math.abs(sum3 - target);
                    res = sum3;
                }
                if (sum3 > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return res;
    }
}
