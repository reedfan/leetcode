package leetcode.shuangzhizhen;

/**
 * leetcode1 209
 * 给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 0。
 * <p>
 * 样例：
 * 给定数组 [2,3,1,2,4,3] 和 s = 7, 子数组 [4,3] 是该条件下的最小长度子数组。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = nums.length;
        while (end < length) {
            sum += nums[end++];
            while (sum >= s) {
                minlen = (end - start) < minlen ? (end - start) : minlen;
                sum -= nums[start++];
            }
        }

        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
