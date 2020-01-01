package leetcode.shuangzhizhen;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N016ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        new N016ThreeSumClosest().threeSumClosest(nums, 1);
    }

    /*

本题最容易想到的方法应该就是暴力破解，但是靠暴力破解的话时间复杂度会到 O(n^3)，面试中显然不能让面试官满意。
采取如下方式可以将时间复杂度优化为 O(n^2)。
首先对数组进行排序，排序的时间复杂度 O(nlogn)。
在数组 nums 中，进行遍历，每遍历一个值取其下标i，形成一个固定值 nums[i]
再使用左指针 left = i + 1 ，右指针 right = nums.length - 1 。
根据 sum = nums[i] + nums[left] + nums[right] 的结果，
并判断 sum 与 target 的大小关系，因为数组有序，如果 sum == target 则说明距离为 0 直接返回结果，如果 sum < target 则 left++，
如果 sum > target 则 right--，并不断更新返回值。
整个遍历过程时间复杂度为 O(n^2)
因此总时间复杂度：O(n^2)。
*/

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
                if (sum3 == target) {
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


    public int threeSumClosest1(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int tmp = sum - target;
                if (tmp == 0) {
                    return target;
                }
                if (tmp > 0) {
                    res = tmp < Math.abs(res - target) ? sum : res;
                    right--;
                }

                if (tmp < 0) {
                    res = (-tmp) < Math.abs(res - target) ? sum : res;
                    left++;
                }

            }
        }
        return res;


    }

}
