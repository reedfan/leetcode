package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N560subarraySum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0};
        System.out.println(new N560subarraySum().subarraySum(nums,0));
    }

    /**
     *
     * 简化求和，将其复杂度减小为O(1)：
     *
     * 在暴力求解的方法中，我们我们在计算连续区间和的时候，重复计算了很多次。我们使用dp数组去存储从0到i的连续子数组的和(前闭后开)，其中从i到j的区间和（前闭后开）为dp[j]-dp[i]
     *
     * int[] dp = new int[nums.length + 1];
     * for (int i = 1; i <= nums.length; i++) {
     * 	dp[i] = dp[i - 1] + nums[i - 1];
     * }
     *
     * 使用Map储存结果，将搜索的复杂度减小为O(n)
     *
     * 在有了第一步结果后，我们将问题转化为：
     *
     * 给定一个数组，是否存在两个数的差等于target，如果存在，请问有多少种情况
     *
     * 这种情况下，就非常类似于数组中两数求和1. 两数之和，我们将遍历的结果加到set中，使用常数时间进行查找，但是第一题只要求找到一个结果即可，所以用Set(Set本质上就是Map)。但是在本文中，当我们查找dp[i]-k时，对应的dp[j]可能不唯一，这也对应了本问题的多种答案，所以，我们使用Map去存储，key是dp[i]，value是dp[j]有多少种选择。
     *
     * 作者：IBITM
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/dai-you-xiang-xi-jie-shi-shi-jian-fu-za-du-wei-ond/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < dp.length; i++) {
            int key = dp[i] - k;
            if (map.containsKey(key)) {
                res += map.get(key);
            }
            if (map.containsKey(dp[i])) {
                map.put(dp[i], map.get(dp[i])+ 1);
            } else {
                map.put(dp[i], 1);
            }
        }
        return res;
    }


    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;

    }
}
