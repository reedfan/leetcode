package leetcode.array;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 8, 8, 8]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N581findUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new N581findUnsortedSubarray().findUnsortedSubarray(nums));
    }

    /**
     *
     * 从右向左找left，left满足的条件为其左边的值都比left位置的值小。因此只要nums[i] <= min，就更新min 的值，否则记录当前位置
     * 同理从右往左找right
     */

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int len = nums.length;
        int leftPos = -1;
        int min = nums[len -1];

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                leftPos = i;
            }
        }

        int rightPos = -2;
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                rightPos = i;
            }
        }
        return rightPos - leftPos + 1;

    }
}
