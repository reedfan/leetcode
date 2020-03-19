package leetcode.dp;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

说明:

    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
    你算法的时间复杂度应该为 O(n2) 。

进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N300lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[pos] < nums[i]) {
                dp[++pos] = nums[i];
            } else {
                dp[findPos(dp, nums[i])] = nums[i];
            }

        }
        return pos + 1;


    }

    //找第一个比num大的数的位置
    private int findPos(int[] nums, int num) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == num) {
                return mid;
            }
            if (nums[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return mid;
    }

}
