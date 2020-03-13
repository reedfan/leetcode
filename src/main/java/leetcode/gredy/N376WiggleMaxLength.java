package leetcode.gredy;

import org.junit.Test;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N376WiggleMaxLength {

    @Test
    public void test() {
        int[] nums1 = {3, 3, 3, 2, 5};
        System.out.println(wiggleMaxLength(nums1));

        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(wiggleMaxLength(nums3));

    }

    /**
     *
     */

    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int len = 1;
        Boolean flag = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (flag == null || flag != (nums[i] > nums[i - 1])) {
                len++;
                flag = nums[i] > nums[i - 1];

            }

        }
        return len;

    }


}
