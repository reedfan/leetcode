package leetcode.huadongchuangkou;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N209minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = new N209minSubArrayLen().minSubArrayLen(7, nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        int sum = nums[0];
        while (left < nums.length) {
            if (sum >= s) {
                minLen = minLen < (right - left) ? minLen : (right - left);
                sum -= nums[left];
                left++;
            } else {
                if (right < nums.length) {
                    sum += nums[right++];
                } else {
                    return minLen == Integer.MAX_VALUE ? 0 : minLen;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
