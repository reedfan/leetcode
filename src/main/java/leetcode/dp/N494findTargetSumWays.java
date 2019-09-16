package leetcode.dp;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N494findTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1};
        new N494findTargetSumWays().findTargetSumWays(nums, 1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[target];
    }


    /**
     *
     *DFS
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, S + nums[start])
                + findTargetSumWays(nums, start + 1, S - nums[start]);
    }
     */
}
